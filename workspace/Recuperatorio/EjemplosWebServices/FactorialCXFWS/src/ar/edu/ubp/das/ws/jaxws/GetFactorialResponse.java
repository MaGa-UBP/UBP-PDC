
package ar.edu.ubp.das.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.3
 * Mon Oct 12 19:29:03 ART 2015
 * Generated source version: 3.1.3
 */

@XmlRootElement(name = "getFactorialResponse", namespace = "http://ws.das.ubp.edu.ar/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFactorialResponse", namespace = "http://ws.das.ubp.edu.ar/")

public class GetFactorialResponse {

    @XmlElement(name = "return")
    private long[] _return;

    public long[] getReturn() {
        return this._return;
    }

    public void setReturn(long[] new_return)  {
        this._return = new_return;
    }

}

