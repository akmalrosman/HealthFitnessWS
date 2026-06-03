
package com.fitness.client.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculateCaloriesBurnRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateCaloriesBurnRate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="activityMultiplier" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateCaloriesBurnRate", propOrder = {
    "weight",
    "height",
    "age",
    "gender",
    "activityMultiplier"
})
public class CalculateCaloriesBurnRate {

    protected double weight;
    protected double height;
    protected int age;
    protected String gender;
    protected double activityMultiplier;

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
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
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
     * Gets the value of the activityMultiplier property.
     * 
     */
    public double getActivityMultiplier() {
        return activityMultiplier;
    }

    /**
     * Sets the value of the activityMultiplier property.
     * 
     */
    public void setActivityMultiplier(double value) {
        this.activityMultiplier = value;
    }

}
