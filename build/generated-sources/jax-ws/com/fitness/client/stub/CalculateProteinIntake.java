
package com.fitness.client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculateProteinIntake complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateProteinIntake"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="weightKg" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="goal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateProteinIntake", propOrder = {
    "weightKg",
    "goal"
})
public class CalculateProteinIntake {

    protected double weightKg;
    protected String goal;

    /**
     * Gets the value of the weightKg property.
     * 
     */
    public double getWeightKg() {
        return weightKg;
    }

    /**
     * Sets the value of the weightKg property.
     * 
     */
    public void setWeightKg(double value) {
        this.weightKg = value;
    }

    /**
     * Gets the value of the goal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoal() {
        return goal;
    }

    /**
     * Sets the value of the goal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoal(String value) {
        this.goal = value;
    }

}
