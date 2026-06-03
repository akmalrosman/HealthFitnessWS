
package com.fitness.client.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fitness.client.stub package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BodyFatPercentage_QNAME = new QName("http://ws.fitness.com/", "bodyFatPercentage");
    private final static QName _BodyFatPercentageResponse_QNAME = new QName("http://ws.fitness.com/", "bodyFatPercentageResponse");
    private final static QName _CalculateCaloriesBurnRate_QNAME = new QName("http://ws.fitness.com/", "calculateCaloriesBurnRate");
    private final static QName _CalculateCaloriesBurnRateResponse_QNAME = new QName("http://ws.fitness.com/", "calculateCaloriesBurnRateResponse");
    private final static QName _CalculateCaloriesDeficit_QNAME = new QName("http://ws.fitness.com/", "calculateCaloriesDeficit");
    private final static QName _CalculateCaloriesDeficitResponse_QNAME = new QName("http://ws.fitness.com/", "calculateCaloriesDeficitResponse");
    private final static QName _CalculateProteinIntake_QNAME = new QName("http://ws.fitness.com/", "calculateProteinIntake");
    private final static QName _CalculateProteinIntakeResponse_QNAME = new QName("http://ws.fitness.com/", "calculateProteinIntakeResponse");
    private final static QName _DetermineAge_QNAME = new QName("http://ws.fitness.com/", "determineAge");
    private final static QName _DetermineAgeResponse_QNAME = new QName("http://ws.fitness.com/", "determineAgeResponse");
    private final static QName _DisplayUserInfo_QNAME = new QName("http://ws.fitness.com/", "displayUserInfo");
    private final static QName _DisplayUserInfoResponse_QNAME = new QName("http://ws.fitness.com/", "displayUserInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fitness.client.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BodyFatPercentage }
     * 
     */
    public BodyFatPercentage createBodyFatPercentage() {
        return new BodyFatPercentage();
    }

    /**
     * Create an instance of {@link BodyFatPercentageResponse }
     * 
     */
    public BodyFatPercentageResponse createBodyFatPercentageResponse() {
        return new BodyFatPercentageResponse();
    }

    /**
     * Create an instance of {@link CalculateCaloriesBurnRate }
     * 
     */
    public CalculateCaloriesBurnRate createCalculateCaloriesBurnRate() {
        return new CalculateCaloriesBurnRate();
    }

    /**
     * Create an instance of {@link CalculateCaloriesBurnRateResponse }
     * 
     */
    public CalculateCaloriesBurnRateResponse createCalculateCaloriesBurnRateResponse() {
        return new CalculateCaloriesBurnRateResponse();
    }

    /**
     * Create an instance of {@link CalculateCaloriesDeficit }
     * 
     */
    public CalculateCaloriesDeficit createCalculateCaloriesDeficit() {
        return new CalculateCaloriesDeficit();
    }

    /**
     * Create an instance of {@link CalculateCaloriesDeficitResponse }
     * 
     */
    public CalculateCaloriesDeficitResponse createCalculateCaloriesDeficitResponse() {
        return new CalculateCaloriesDeficitResponse();
    }

    /**
     * Create an instance of {@link CalculateProteinIntake }
     * 
     */
    public CalculateProteinIntake createCalculateProteinIntake() {
        return new CalculateProteinIntake();
    }

    /**
     * Create an instance of {@link CalculateProteinIntakeResponse }
     * 
     */
    public CalculateProteinIntakeResponse createCalculateProteinIntakeResponse() {
        return new CalculateProteinIntakeResponse();
    }

    /**
     * Create an instance of {@link DetermineAge }
     * 
     */
    public DetermineAge createDetermineAge() {
        return new DetermineAge();
    }

    /**
     * Create an instance of {@link DetermineAgeResponse }
     * 
     */
    public DetermineAgeResponse createDetermineAgeResponse() {
        return new DetermineAgeResponse();
    }

    /**
     * Create an instance of {@link DisplayUserInfo }
     * 
     */
    public DisplayUserInfo createDisplayUserInfo() {
        return new DisplayUserInfo();
    }

    /**
     * Create an instance of {@link DisplayUserInfoResponse }
     * 
     */
    public DisplayUserInfoResponse createDisplayUserInfoResponse() {
        return new DisplayUserInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BodyFatPercentage }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BodyFatPercentage }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "bodyFatPercentage")
    public JAXBElement<BodyFatPercentage> createBodyFatPercentage(BodyFatPercentage value) {
        return new JAXBElement<BodyFatPercentage>(_BodyFatPercentage_QNAME, BodyFatPercentage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BodyFatPercentageResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BodyFatPercentageResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "bodyFatPercentageResponse")
    public JAXBElement<BodyFatPercentageResponse> createBodyFatPercentageResponse(BodyFatPercentageResponse value) {
        return new JAXBElement<BodyFatPercentageResponse>(_BodyFatPercentageResponse_QNAME, BodyFatPercentageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesBurnRate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesBurnRate }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "calculateCaloriesBurnRate")
    public JAXBElement<CalculateCaloriesBurnRate> createCalculateCaloriesBurnRate(CalculateCaloriesBurnRate value) {
        return new JAXBElement<CalculateCaloriesBurnRate>(_CalculateCaloriesBurnRate_QNAME, CalculateCaloriesBurnRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesBurnRateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesBurnRateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "calculateCaloriesBurnRateResponse")
    public JAXBElement<CalculateCaloriesBurnRateResponse> createCalculateCaloriesBurnRateResponse(CalculateCaloriesBurnRateResponse value) {
        return new JAXBElement<CalculateCaloriesBurnRateResponse>(_CalculateCaloriesBurnRateResponse_QNAME, CalculateCaloriesBurnRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesDeficit }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesDeficit }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "calculateCaloriesDeficit")
    public JAXBElement<CalculateCaloriesDeficit> createCalculateCaloriesDeficit(CalculateCaloriesDeficit value) {
        return new JAXBElement<CalculateCaloriesDeficit>(_CalculateCaloriesDeficit_QNAME, CalculateCaloriesDeficit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesDeficitResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculateCaloriesDeficitResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "calculateCaloriesDeficitResponse")
    public JAXBElement<CalculateCaloriesDeficitResponse> createCalculateCaloriesDeficitResponse(CalculateCaloriesDeficitResponse value) {
        return new JAXBElement<CalculateCaloriesDeficitResponse>(_CalculateCaloriesDeficitResponse_QNAME, CalculateCaloriesDeficitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateProteinIntake }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculateProteinIntake }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "calculateProteinIntake")
    public JAXBElement<CalculateProteinIntake> createCalculateProteinIntake(CalculateProteinIntake value) {
        return new JAXBElement<CalculateProteinIntake>(_CalculateProteinIntake_QNAME, CalculateProteinIntake.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateProteinIntakeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalculateProteinIntakeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "calculateProteinIntakeResponse")
    public JAXBElement<CalculateProteinIntakeResponse> createCalculateProteinIntakeResponse(CalculateProteinIntakeResponse value) {
        return new JAXBElement<CalculateProteinIntakeResponse>(_CalculateProteinIntakeResponse_QNAME, CalculateProteinIntakeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineAge }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetermineAge }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "determineAge")
    public JAXBElement<DetermineAge> createDetermineAge(DetermineAge value) {
        return new JAXBElement<DetermineAge>(_DetermineAge_QNAME, DetermineAge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineAgeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetermineAgeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "determineAgeResponse")
    public JAXBElement<DetermineAgeResponse> createDetermineAgeResponse(DetermineAgeResponse value) {
        return new JAXBElement<DetermineAgeResponse>(_DetermineAgeResponse_QNAME, DetermineAgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayUserInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DisplayUserInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "displayUserInfo")
    public JAXBElement<DisplayUserInfo> createDisplayUserInfo(DisplayUserInfo value) {
        return new JAXBElement<DisplayUserInfo>(_DisplayUserInfo_QNAME, DisplayUserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayUserInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DisplayUserInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.fitness.com/", name = "displayUserInfoResponse")
    public JAXBElement<DisplayUserInfoResponse> createDisplayUserInfoResponse(DisplayUserInfoResponse value) {
        return new JAXBElement<DisplayUserInfoResponse>(_DisplayUserInfoResponse_QNAME, DisplayUserInfoResponse.class, null, value);
    }

}
