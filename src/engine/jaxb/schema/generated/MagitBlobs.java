
package engine.jaxb.schema.generated;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}MagitBlob" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "magitBlob"
})
@XmlRootElement(name = "MagitBlobs")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-08-11T12:12:34+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MagitBlobs {

    @XmlElement(name = "MagitBlob")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-08-11T12:12:34+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<MagitBlob> magitBlob;

    /**
     * Gets the value of the magitBlob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the magitBlob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMagitBlob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MagitBlob }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-08-11T12:12:34+03:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<MagitBlob> getMagitBlob() {
        if (magitBlob == null) {
            magitBlob = new ArrayList<MagitBlob>();
        }
        return this.magitBlob;
    }

}
