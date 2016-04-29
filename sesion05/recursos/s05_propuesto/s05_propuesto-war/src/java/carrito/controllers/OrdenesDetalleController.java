package carrito.controllers;

import carrito.entidades.OrdenesDetalle;
import carrito.controllers.util.JsfUtil;
import carrito.controllers.util.JsfUtil.PersistAction;
import carrito.fachada.OrdenesDetalleFacade;
import carrito.fachada.OrdenesDetalleFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ordenesDetalleController")
@SessionScoped
public class OrdenesDetalleController implements Serializable {

    @EJB
    private OrdenesDetalleFacadeLocal ejbFacade;
    private List<OrdenesDetalle> items = null;
    private OrdenesDetalle selected;

    public OrdenesDetalleController() {
    }

    public OrdenesDetalle getSelected() {
        return selected;
    }

    public void setSelected(OrdenesDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getOrdenesDetallePK().setOrden(selected.getOrdenes().getOrden());
        selected.getOrdenesDetallePK().setCodigo(selected.getProductos().getProductosPK().getCodigo());
    }

    protected void initializeEmbeddableKey() {
        selected.setOrdenesDetallePK(new carrito.entidades.OrdenesDetallePK());
    }

    private OrdenesDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public OrdenesDetalle prepareCreate() {
        selected = new OrdenesDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OrdenesDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OrdenesDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OrdenesDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OrdenesDetalle> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public OrdenesDetalle getOrdenesDetalle(carrito.entidades.OrdenesDetallePK id) {
        return getFacade().find(id);
    }

    public List<OrdenesDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OrdenesDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OrdenesDetalle.class)
    public static class OrdenesDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdenesDetalleController controller = (OrdenesDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenesDetalleController");
            return controller.getOrdenesDetalle(getKey(value));
        }

        carrito.entidades.OrdenesDetallePK getKey(String value) {
            carrito.entidades.OrdenesDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new carrito.entidades.OrdenesDetallePK();
            key.setOrden(Integer.parseInt(values[0]));
            key.setCodigo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(carrito.entidades.OrdenesDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getOrden());
            sb.append(SEPARATOR);
            sb.append(value.getCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OrdenesDetalle) {
                OrdenesDetalle o = (OrdenesDetalle) object;
                return getStringKey(o.getOrdenesDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OrdenesDetalle.class.getName()});
                return null;
            }
        }

    }

}
