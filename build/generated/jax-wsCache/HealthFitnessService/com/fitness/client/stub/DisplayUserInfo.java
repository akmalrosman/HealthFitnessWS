
package com.fitness.client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for displayUserInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="displayUserInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="icNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="activityLevel" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="targetWeight" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="weeks" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "displayUserInfo", propOrder = {
    "name",
    "icNumber",
    "gender",
    "weight",
    "height",
    "activityLevel",
    "targetWeight",
    "weeks"
})
public class DisplayUserInfo {

    protected String name;
    protected String icNumber;
    protected String gender;
    protected double weight;
    protected double height;
    protected double activityLevel;
    protected double targetWeight;
    protected int weeks;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the icNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcNumber() {
        return icNumber;
    }

    /**
     * Sets the value of the icNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcNumber(String value) {
        this.icNumber = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(double value) {
        this.weight = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Gets the value of the activityLevel property.
     * 
     */
    public double getActivityLevel() {
        return activityLevel;
    }

    /**
     * Sets the value of the activityLevel property.
     * 
     */
    public void setActivityLevel(double value) {
        this.activityLevel = value;
    }

    /**
     * Gets the value of the targetWeight property.
     * 
     */
    public double getTargetWeight() {
        return targetWeight;
    }

    /**
     * Sets the value of the targetWeight property.
     * 
     */
    public void setTargetWeight(double value) {
        this.targetWeight = value;
    }

    /**
     * Gets the value of the weeks property.
     * 
     */
    public int getWeeks() {
        return weeks;
    }

    /**
     * Sets the value of the weeks property.
     * 
     */
    public void setWeeks(int value) {
        this.weeks = value;
    }

}
