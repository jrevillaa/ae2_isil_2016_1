/**
 *
 * @author Alumno-CT
 * Jair Revilla
 */
package ae2.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alumno-CT
 * Jair Revilla
 */
@Entity
@Table(name = "tb_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProducto.findAll", query = "SELECT t FROM TbProducto t"),
    @NamedQuery(name = "TbProducto.findByCodpro", query = "SELECT t FROM TbProducto t WHERE t.codpro = :codpro"),
    @NamedQuery(name = "TbProducto.findByDespro", query = "SELECT t FROM TbProducto t WHERE t.despro = :despro"),
    @NamedQuery(name = "TbProducto.findByPrepro", query = "SELECT t FROM TbProducto t WHERE t.prepro = :prepro"),
    @NamedQuery(name = "TbProducto.findByStkact", query = "SELECT t FROM TbProducto t WHERE t.stkact = :stkact"),
    @NamedQuery(name = "TbProducto.findByStkmin", query = "SELECT t FROM TbProducto t WHERE t.stkmin = :stkmin"),
    @NamedQuery(name = "TbProducto.findByLinpro", query = "SELECT t FROM TbProducto t WHERE t.linpro = :linpro"),
    @NamedQuery(name = "TbProducto.rango", query = "SELECT t FROM TbProducto t WHERE t.stkact >= :stmin AND t.stkact <= :stmax"),
    @NamedQuery(name = "TbProducto.nombre", query = "SELECT t FROM TbProducto t WHERE t.despro LIKE :nomb"),
    @NamedQuery(name = "TbProducto.buscar", query = "SELECT t FROM TbProducto t ORDER BY t.despro"),
    @NamedQuery(name = "TbProducto.findByImportado", query = "SELECT t FROM TbProducto t WHERE t.importado = :importado")})
public class TbProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Cod_pro")
    private String codpro;
    @Size(max = 25)
    @Column(name = "Des_pro")
    private String despro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Pre_pro")
    private Double prepro;
    @Column(name = "Stk_act")
    private Integer stkact;
    @Column(name = "Stk_min")
    private Integer stkmin;
    @Size(max = 1)
    @Column(name = "Lin_pro")
    private String linpro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Importado")
    private boolean importado;

    public TbProducto() {
    }

    public TbProducto(String codpro) {
        this.codpro = codpro;
    }

    public TbProducto(String codpro, boolean importado) {
        this.codpro = codpro;
        this.importado = importado;
    }

    public String getCodpro() {
        return codpro;
    }

    public void setCodpro(String codpro) {
        this.codpro = codpro;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public Double getPrepro() {
        return prepro;
    }

    public void setPrepro(Double prepro) {
        this.prepro = prepro;
    }

    public Integer getStkact() {
        return stkact;
    }

    public void setStkact(Integer stkact) {
        this.stkact = stkact;
    }

    public Integer getStkmin() {
        return stkmin;
    }

    public void setStkmin(Integer stkmin) {
        this.stkmin = stkmin;
    }

    public String getLinpro() {
        return linpro;
    }

    public void setLinpro(String linpro) {
        this.linpro = linpro;
    }

    public boolean getImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpro != null ? codpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProducto)) {
            return false;
        }
        TbProducto other = (TbProducto) object;
        if ((this.codpro == null && other.codpro != null) || (this.codpro != null && !this.codpro.equals(other.codpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ae2.entidades.TbProducto[ codpro=" + codpro + " ]";
    }
    
}
