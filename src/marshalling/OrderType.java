


package marshalling;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for orderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{}customerType"/>
 *         &lt;element name="items" type="{}itemsType"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="shipping" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="HST" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="grandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="submitted" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderType", propOrder = {
    "customer",
    "items",
    "total",
    "shipping",
    "hst",
    "grandTotal"
})
public class OrderType {

    @XmlElement(required = true)
    protected CustomerType customer;
    @XmlElement(required = true)
    protected ItemsType items;
    @XmlElement(required = true)
    protected BigDecimal total;
    @XmlElement(required = true)
    protected BigDecimal shipping;
    @XmlElement(name = "HST", required = true)
    protected BigDecimal hst;
    @XmlElement(required = true)
    protected BigDecimal grandTotal;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger id;
    @XmlAttribute(name = "submitted")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar submitted;

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerType }
     *     
     */
    public CustomerType getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerType }
     *     
     */
    public void setCustomer(CustomerType value) {
        this.customer = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link ItemsType }
     *     
     */
    public ItemsType getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemsType }
     *     
     */
    public void setItems(ItemsType value) {
        this.items = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Gets the value of the shipping property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShipping() {
        return shipping;
    }

    /**
     * Sets the value of the shipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShipping(BigDecimal value) {
        this.shipping = value;
    }

    /**
     * Gets the value of the hst property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHST() {
        return hst;
    }

    /**
     * Sets the value of the hst property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHST(BigDecimal value) {
        this.hst = value;
    }

    /**
     * Gets the value of the grandTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    /**
     * Sets the value of the grandTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrandTotal(BigDecimal value) {
        this.grandTotal = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the submitted property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitted() {
        return submitted;
    }

    /**
     * Sets the value of the submitted property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitted(XMLGregorianCalendar value) {
        this.submitted = value;
    }

}
