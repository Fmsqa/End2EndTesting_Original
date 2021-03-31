import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class InsuranceEndtoEndTesting {
    WebDriver driver;

    @BeforeTest
    public void openBrowser(){
        System.setProperty("Webdriver.chrome.driver","driver/chrome/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


    @Test
    public void verifyNevadaCarInsuranceE2ETesting() {
        String link = "https://insurancewebsitedemo.com/personal-insurance/car-insurance";
        driver.get(link);
        String expectedTitle = "Auto, Automobile, Car, Vehicle Insurance in Las Vegas Nevada - Demo Insurance Agency,";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Home page title verification is pass");

    // Covid Notice pop up close click
        driver.findElement(By.id("notice-close")).click();

    // Navigate to the second page
        WebElement QuoteRequestLink = driver.findElement(By.linkText("Auto Insurance Quote Request"));
        QuoteRequestLink.click();
        System.out.println("Successfully go to the second page");

    // Validate Quote form page_ second Page
        WebElement headerText =  driver.findElement(By.id("title_div"));
        String actualHeaderText = headerText.getText();
        String expectedHeaderText = "Secure Auto Insurance Quote Request Form";
        Assert.assertEquals(actualHeaderText,expectedHeaderText);
        System.out.println("Quote form page Header text validation is pass");

    // Input required information
    // Insert First Name
        WebElement firstName = driver.findElement(By.id("fname"));
        String firstNameVal = "John";
        firstName.sendKeys(firstNameVal);

    // Insert Last Name
        WebElement lasttName = driver.findElement(By.id("lname"));
        String lastNameVal = "Roberts";
        lasttName.sendKeys(lastNameVal);

    // Insert email Address
        WebElement emailAddress = driver.findElement(By.id("email"));
        String email = "tester123@test.com";
        emailAddress.sendKeys(email);

    // Insert phone Number
        WebElement phoneNumber = driver.findElement(By.id("phone"));
        String PhoneNo = "111222333";
        phoneNumber.sendKeys(PhoneNo);

    // Insert Zip code
        WebElement zipCode = driver.findElement(By.id("zip"));
        zipCode.sendKeys("11102");

    //continueToNextPage
        WebElement continueToNextPage = driver.findElement(By.id("sfs-one-start"));
        continueToNextPage.click();

    //Assertion
        WebElement progress_id = driver.findElement(By.id("progress_id"));
        String actualProgressResult = progress_id.getText();
        String expectedProgressResult = "Step 1 of 4";
        Assert.assertEquals(actualProgressResult, expectedProgressResult);
        System.out.println("Step 1 of 4 assertion test page is pass");

    // Assert First Name
        WebElement firsNameValue = driver.findElement(By.id("fname"));
        String actualFirstNameValue = firsNameValue.getAttribute("value");
        String expectedFirstNameVal = firstNameVal;
        Assert.assertEquals(actualFirstNameValue, expectedFirstNameVal);
        System.out.println("First Name assertion (John) is pass");


    // Assert Last Name
        WebElement lastNameValue = driver.findElement(By.id("lname"));
        String actualLastNameValue = lastNameValue.getAttribute("value");
        String expectedLastNameVal = lastNameVal;
        Assert.assertEquals(actualLastNameValue, expectedLastNameVal);
        System.out.println("Last Name assertion (Roberts) is pass");

    // Assert Email address
        WebElement emailinfo = driver.findElement(By.id("email"));
        String actualemailinfo = emailinfo.getAttribute("value");
        String expectedemailinfo = email;
        Assert.assertEquals(actualemailinfo, expectedemailinfo);
        System.out.println("Email assertion (tester123@test.com) is pass");

    // Assert Phone Number
        WebElement phoneinfo = driver.findElement(By.id("phone"));
        String actualPhonelinfo = phoneinfo.getAttribute("value");
        String expectedPhoneinfo = PhoneNo;
        Assert.assertEquals(actualPhonelinfo, expectedPhoneinfo);
        System.out.println("Phone no assertion (111222333) is pass");

    // Insert Address
        WebElement address = driver.findElement(By.id("address"));
        String addressInfo = "123 - 21 Ave, Apt# 1A";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        address.click();address.click();address.click();address.click();address.click();
        address.click();address.click();address.click();address.click();address.click();
        address.click();address.click();address.click();
        address.click(); address.click();
        address.sendKeys(addressInfo);


    // Selecet Month from Dropdown Menu
        WebElement month = driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][month]"));
        selectValueFromDropDown(month, "December");
        System.out.println("Month Dropdown Menu is working");


    // Selecet Date from Dropdown Menu
        WebElement day = driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][day]"));
        selectValueFromDropDown(day, "27");
        System.out.println("Day Dropdown Menu is working");

    // Selecet Year from Dropdown Menu
        WebElement year = driver.findElement(By.name("form_data[applicant_info][_crypt_date_DOB][year]"));
        selectValueFromDropDown(year, "2000");
        System.out.println("Year Dropdown Menu is working");

    // Selecet Occupation from Dropdown Menu
        WebElement occupation = driver.findElement(By.name("form_data[applicant_info][occupation]"));
        selectValueFromDropDown(occupation, "Dentist");
        System.out.println("Occupation Dropdown Menu is working");

    // Selecet Education from Dropdown Menu
        WebElement education = driver.findElement(By.name("form_data[applicant_info][education]"));
        selectValueFromDropDown(education, "Bachelors Degree");
        System.out.println("Education Dropdown Menu is working");

    // Insert SSN
        WebElement ssn = driver.findElement(By.id("ssn"));
        String ssNo = "9090909090";
        ssn.sendKeys(ssNo);
        System.out.println("SSN input is successfully done");


    //  Selecet Credit Report Consent -- from Dropdown Menu
        WebElement creditRiportConcent = driver.findElement(By.name("form_data[applicant_info][report_consent]"));
        selectValueFromDropDown(creditRiportConcent, "Yes");
        System.out.println("Credit Report Consent Dropdown Menu is working");

    //  Selecet Residence Type -- from Dropdown Menu
        WebElement residentType = driver.findElement(By.name("form_data[applicant_info][residence_type]"));
        selectValueFromDropDown(residentType, "Apartment");
        System.out.println("Residence Type Dropdown Menu is working");

    //  Selecet Residence Ownership -- from Dropdown Menu
        WebElement residentOwnership = driver.findElement(By.name("form_data[applicant_info][home_ownership]"));
        selectValueFromDropDown(residentOwnership, "Rent");
        System.out.println("Residence Ownership Dropdown Menu is working");


    //  Selecet Marital Status -- from Dropdown Menu
        WebElement maritalStatus = driver.findElement(By.name("form_data[applicant_info][marital_status]"));
        selectValueFromDropDown(maritalStatus, "Married");
        System.out.println("Marital Status Dropdown Menu is working");

    //continueToNextPage
        WebElement continueToStep_2 = driver.findElement(By.name("next"));
        continueToStep_2.click();

    // Assert Step 2
        WebElement vehicleInformationText = driver.findElement(By.id("instructions_div"));
        String acualvehicleInformationText = vehicleInformationText.getText();
        String expectedvehicleInformationText = "Fill out as much information as you want. You may skip any of the following questions, but the more information you provide, the more accurate your quote will be.\n" +
                "\n" +
                "** It would be best to have at least these fields completed.";
        Assert.assertEquals(acualvehicleInformationText,expectedvehicleInformationText);
        System.out.println("Assertion of  Step 2 is done");

    // Insert info in "Vehicle 1 Year" tag section:
        WebElement vehicle1Year = driver.findElement(By.name("form_data[vehicle_info][year_1]"));
        String vehiclesYear = "2018";
        vehicle1Year.click();vehicle1Year.click();vehicle1Year.click();vehicle1Year.click();
        vehicle1Year.click();vehicle1Year.click();vehicle1Year.click();vehicle1Year.click();
        vehicle1Year.click();vehicle1Year.click();vehicle1Year.click();vehicle1Year.click();
        vehicle1Year.sendKeys(vehiclesYear);

    // Insert info in "Vehicle 1 Make" tag section:
        WebElement vehicle1Make = driver.findElement(By.name("form_data[vehicle_info][make_1]"));
        String vehiclesMake = "Nissan";
        vehicle1Make.click();
        vehicle1Make.sendKeys(vehiclesMake);

    // Insert info in "Vehicle 1 Model" tag section:
        WebElement vehiclesModel = driver.findElement(By.name("form_data[vehicle_info][model_1]"));
        String vehicleModel = "Versa";
        vehiclesModel.click();
        vehiclesModel.sendKeys(vehicleModel);

    // Select from "Vehicle 1 Body Type" tag section:
        WebElement vehicle1BodyType = driver.findElement(By.name("form_data[vehicle_info][body_type_1]"));
        String vehiclesBodyType  = "Electric Car";
        selectValueFromDropDown(vehicle1BodyType, vehiclesBodyType);
        System.out.println("Vehicle 1 Body Type Dropdown Menu is working");

    // Insert info in "Vehicle 1 VIN" tag section:
        WebElement vehiclesVIN = driver.findElement(By.name("form_data[vehicle_info][VIN_1]"));
        String vehiclesVin = "XPYZ-UTRCV-44559900";
        vehiclesVIN.click();
        vehiclesVIN.sendKeys(vehiclesVin);

    // Select from "Ownership" tag section:
        WebElement vehicleOwnership = driver.findElement(By.name("form_data[vehicle_info][ownership_1]"));
        String vehiclesOwnership  = "Owned";
        selectValueFromDropDown(vehicleOwnership, vehiclesOwnership);
        System.out.println("Ownership Dropdown Menu is working");

    // Insert info in "Name on Title" tag section:
        WebElement titleName = driver.findElement(By.name("form_data[vehicle_info][titled_to_1]"));
        String lienholderName = "Mr. John Roberts";
        titleName.click();
        titleName.sendKeys(lienholderName);

    // Insert info in "Lienholder Address if applicable" tag section:
        WebElement lienholderAddress = driver.findElement(By.name("form_data[vehicle_info][lienholder_address_1]"));
        String lienholderCurrentAddress = "123 - 21 Ave, Apt# 1A";
        lienholderAddress.click();
        lienholderAddress.sendKeys(lienholderCurrentAddress);

    // Insert info in "Current Odometer" tag section:
        WebElement odometerReading = driver.findElement(By.name("form_data[vehicle_info][current_odometer_1]"));
        String CurrentOdometerReading = "30000 Miles";
        odometerReading.click();
        odometerReading.sendKeys(CurrentOdometerReading);

    // Insert info in "Days Driven Per Week" tag section:
        WebElement drivePerWeek = driver.findElement(By.name("form_data[vehicle_info][days_driven_per_week_1]"));
        String weeklyDriving = "5 Days";
        drivePerWeek.click();
        drivePerWeek.sendKeys(weeklyDriving);

    // Insert info in " Distance One Way" tag section:
        WebElement oneWayDistance = driver.findElement(By.name("form_data[vehicle_info][distance_one_way_1]"));
        String drivingOneWayDistance = "5 miles";
        oneWayDistance.click();
        oneWayDistance.sendKeys(drivingOneWayDistance);


     // Insert info in "Estimated Yearly Mileage" tag section:
        WebElement yearlyMileage = driver.findElement(By.name("form_data[vehicle_info][yearly_mileage_1]"));
        String yearlyMileageCount = "5000 miles";
        yearlyMileage.click();
        yearlyMileage.sendKeys(yearlyMileageCount);


    // Insert info in "Primary Use" tag section:
        WebElement useFor = driver.findElement(By.name("form_data[vehicle_info][use_1]"));
        String useToGo = "To/From Work";
        selectValueFromDropDown(useFor, useToGo);


    // select from "Location Parked at Night" tag section:
        WebElement nightParking = driver.findElement(By.name("form_data[vehicle_info][garaging_1]"));
        String nightParkingLocation = "Street";
        selectValueFromDropDown(nightParking, nightParkingLocation);


    // select from "Anti Theft Features" tag section:
        WebElement antiThreftFeatures = driver.findElement(By.name("form_data[vehicle_info][anti_theft_features_1][]"));
        String antiThreftOption = "Alarm";
        selectValueFromDropDown(antiThreftFeatures, antiThreftOption);


    // select from "Passive Restraints" tag section:
        WebElement passiveRestraints = driver.findElement(By.name("form_data[vehicle_info][passive_restraints_1][]"));
        String passiveRestraintsOption = "Driver Side Airbag";
        selectValueFromDropDown(passiveRestraints, passiveRestraintsOption);

    // select from "Anti-Lock Brakes" tag section:
        WebElement antiLockBrakes = driver.findElement(By.name("form_data[vehicle_info][Anti-Lock_brakes_1]"));
        String antiLockBrakesOption = "Yes";
        selectValueFromDropDown(antiLockBrakes, antiLockBrakesOption);

    // select from "Daytime Running Lights" tag section:
        WebElement dayRunningLights = driver.findElement(By.name("form_data[vehicle_info][daytime_running_lights_1]"));
        String dayTimeRunningLights = "Yes";
        selectValueFromDropDown(dayRunningLights, dayTimeRunningLights);

    // select from "Any Prior Damage to Vehicle?" tag section:
        WebElement previousDamageHistory = driver.findElement(By.name("form_data[vehicle_info][prior_damage_1]"));
        String carsPreviousDamageHistory = "No";
        selectValueFromDropDown(previousDamageHistory, carsPreviousDamageHistory);


    // select from "Vehicle Ever Used for Deliveries?" tag section:
        WebElement carUsedDeliveriesTag = driver.findElement(By.name("form_data[vehicle_info][used_for_delivery_1]"));
        String carEverUsedDeliveries = "No";
        selectValueFromDropDown(carUsedDeliveriesTag, carEverUsedDeliveries);

    // select from "Collision Deductible" tag section:
        WebElement collisionDeductibleOption = driver.findElement(By.name("form_data[vehicle_info][collision_deductible_1]"));
        String collisionDeductibleInDollar = "500";
        selectValueFromDropDown(collisionDeductibleOption, collisionDeductibleInDollar);

    // select from "Comprehensive Deductible" tag section:
        WebElement comprehensiveDeductibleOption = driver.findElement(By.name("form_data[vehicle_info][comprehensive_deductible_1]"));
        String comprehensiveDeductibleInDollar = "1000";
        selectValueFromDropDown(comprehensiveDeductibleOption, comprehensiveDeductibleInDollar);

    // select from "Towing/Roadside Coverage" tag section:
        WebElement towingAndRoadsideCoverage = driver.findElement(By.name("form_data[vehicle_info][towing_or_roadside_1]"));
        String towingAndRoadsideCoverageInDollar = "250";
        selectValueFromDropDown(towingAndRoadsideCoverage, towingAndRoadsideCoverageInDollar);

    // select from "Rental Reimbursement" tag section:
        WebElement rentalReimbursementCoverage = driver.findElement(By.name("form_data[vehicle_info][rental_1]"));
        String rentalReimbursementCoverageInDollar = "50";
        selectValueFromDropDown(rentalReimbursementCoverage, rentalReimbursementCoverageInDollar);

    // select from "Full Glass Coverage?" tag section:
        WebElement fullGlassCoverage = driver.findElement(By.name("form_data[vehicle_info][full_glass_1]"));
        String fullGlassCoverageOption = "Yes";
        selectValueFromDropDown(fullGlassCoverage, fullGlassCoverageOption);

    //continueToNextPage
        WebElement proceedToStep_3 = driver.findElement(By.name("next"));
        proceedToStep_3.click();
        System.out.println("Successfully Proceed To Step_3 Page");

    // Assertion Step 3 of 4 Text
    // Validate Quote form page_ second Page
        WebElement pageHeaderText =  driver.findElement(By.id("progress_id"));
        String actualpageHeaderText = pageHeaderText.getText();
        String expectedpageHeaderText = "Step 3 of 4";
        Assert.assertEquals(actualpageHeaderText,expectedpageHeaderText);
        System.out.println("Step 3 page Header text validation is pass");

    // Assert First and Last Name_ in Step 3 Page
        WebElement firsNameValue1 = driver.findElement(By.id("fname1"));
        WebElement lastNameValue1 = driver.findElement(By.id("lname1"));
        String actualFirstNameValue1 = firsNameValue1.getAttribute("value");
        String actualLastNameValue1 = lastNameValue1.getAttribute("value");
        String expectedFirstNameVal1 = firstNameVal;
        String expectedLastNameVal1 = lastNameVal;

        Assert.assertEquals(actualFirstNameValue1, expectedFirstNameVal1);
        System.out.println("First Name assertion (John) is pass");
        Assert.assertEquals(actualLastNameValue1, expectedLastNameVal1);
        System.out.println("Last Name assertion (Roberts) is pass");

    // Assert SS Number_ in Step 3 Page
        WebElement sSNinfo = driver.findElement(By.id("ss_number"));
        String actualSSNinfo = sSNinfo.getAttribute("value");
        String expectedSSNinfo = ssNo;
        Assert.assertEquals(actualSSNinfo, expectedSSNinfo);


    // select value from "License Status" tag section:
        WebElement licenseStatus = driver.findElement(By.name("form_data[driver_info][license_status_1]"));
        String licenseStatusUpdate = "Active/Valid";
        selectValueFromDropDown(licenseStatus, licenseStatusUpdate);

    // Insert info in "License Number" tag section:
        WebElement lisenseNumber = driver.findElement(By.name("form_data[driver_info][_crypt_license_number_1]"));
        String driverLisenseNumber = "XXX000999";
        lisenseNumber.click(); lisenseNumber.click(); lisenseNumber.click(); lisenseNumber.click();
        lisenseNumber.click(); lisenseNumber.click(); lisenseNumber.click(); lisenseNumber.click();
        lisenseNumber.sendKeys(driverLisenseNumber);

    // select value from "Suspended in Last 5 Year" tag section:
        WebElement last5YearSuspendHistory = driver.findElement(By.name("form_data[driver_info][recent_suspension_1]"));
        String last5YearSuspendedHistory = "No";
        selectValueFromDropDown(last5YearSuspendHistory, last5YearSuspendedHistory);

    // select value from "Do you drive for a ride share company?" tag section:
        WebElement driveForARideShareCompany = driver.findElement(By.name("form_data[driver_info][ride_share_company]"));
        String drivewithRideShareCompany = "No";
        selectValueFromDropDown(driveForARideShareCompany, drivewithRideShareCompany);

    // Insert info in "Age Licensed" tag section:
        WebElement ageLicensed = driver.findElement(By.name("form_data[driver_info][age_licensed_1]"));
        String ageLicensedT = "18";
        ageLicensed.click();
        ageLicensed.sendKeys(ageLicensedT);

    // select value from "Accidents Within 5 Years?" tag section:
        WebElement accedentHistory = driver.findElement(By.name("form_data[driver_info][recent_accidents_1][]"));
        String accedentHistoryLastFiveYears = "No";
        selectValueFromDropDown(accedentHistory, accedentHistoryLastFiveYears);

    // select value from "Violations Within 5 Years?" tag section:
        WebElement violationsHistory = driver.findElement(By.name("form_data[driver_info][recent_violations_1][]"));
        String violationsHistoryLastFiveYears = "No";
        selectValueFromDropDown(violationsHistory, violationsHistoryLastFiveYears);

    // select value from "SR22 Filing?" tag section:
        //In the United States, an SR-22 (sometimes referred to as a certificate of insurance or a financial responsibility filing)
        // is a vehicle liability insurance endorsement required by most state Department of Motor Vehicles (DMV) offices[b] for "high-risk" drivers.
        WebElement sR22History = driver.findElement(By.name("form_data[driver_info][SR22_filing_1]"));
        String sR22FillingHistory = "No";
        selectValueFromDropDown(sR22History, sR22FillingHistory);

    // select value from "Eligible For Good Student Discount?" tag section:
        WebElement goodStudentDiscount = driver.findElement(By.name("form_data[driver_info][good_student_1]"));
        String goodStudentDiscountEligibality = "College Graduate";
        selectValueFromDropDown(goodStudentDiscount, goodStudentDiscountEligibality);


    // select value from "Eligible For Defensive Driver Discount?" tag section:
        WebElement defensiveDriverDiscount = driver.findElement(By.name("form_data[driver_info][defensive_driver_1]"));
        String defensiveDriverEligibality = "Yes";
        selectValueFromDropDown(defensiveDriverDiscount, defensiveDriverEligibality);


    // select value from "Eligible For Drivers Ed Discount? " tag section:
        WebElement edDiscount = driver.findElement(By.name("form_data[driver_info][drivers_ed_1]"));
        String edDiscountEligibality = "Yes";
        selectValueFromDropDown(edDiscount, edDiscountEligibality);

    //continue To The Page -4
        WebElement proceedToStep_4 = driver.findElement(By.name("next"));
        proceedToStep_4.click();
        System.out.println("Successfully Proceed To Step_4 Page");


    // Assert Step 4 of 4 text field _In Finish Page
        WebElement finishPage = driver.findElement(By.id("progress_id"));
        String actualFinishPageText = finishPage.getText();
        String expectedFinishPageText  = "Step 4 of 4";
        Assert.assertEquals(actualFinishPageText,expectedFinishPageText);
        System.out.println("We are in The Finish (Step_4) Page");


    // select value from "Underinsured Motorist" tag section:
        WebElement underinsuredMotorist = driver.findElement(By.name("form_data[coverage_info][underinsured]"));
        String underinsuredMotoristAmount = "$50,000/$100,000";
        selectValueFromDropDown(underinsuredMotorist, underinsuredMotoristAmount);


    // select value from "Medical Payments" tag section:
        WebElement medicalPayments = driver.findElement(By.name("form_data[coverage_info][medical_payments]"));
        String medicalPaymentsAmount = "$20,000";
        selectValueFromDropDown(medicalPayments, medicalPaymentsAmount);


    // select value from "Do you Have Auto Insurance Now?" tag section:
        WebElement currentAutoInsuranceInfo = driver.findElement(By.name("form_data[prior_policy][currently_insured]"));
        String currentAutoInsuranceStatus = "Yes";
        selectValueFromDropDown(currentAutoInsuranceInfo, currentAutoInsuranceStatus);

    // select value from "Previous (or Current) Carrier" tag section:
        WebElement carrierInfo = driver.findElement(By.name("form_data[prior_policy][prior_carrier]"));
        String carrierName = "Allstate";
        selectValueFromDropDown(carrierInfo, carrierName);

   // Insert info in "Current Policy Premium" tag section:
        WebElement policyPremium = driver.findElement(By.name("form_data[prior_policy][current_policy_premium]"));
        String policyPremiumAmount = "$450";
        policyPremium.click();policyPremium.click();policyPremium.click();policyPremium.click();
        policyPremium.click();policyPremium.click();policyPremium.click();policyPremium.click();
        policyPremium.sendKeys(policyPremiumAmount);

    // select value from "Current Policy Expiration" tag section:
        WebElement expireMonth = driver.findElement(By.name("form_data[prior_policy][_date_current_policy_expiration][month]"));
        selectValueFromDropDown(expireMonth, "April");
        WebElement expireDay = driver.findElement(By.name("form_data[prior_policy][_date_current_policy_expiration][day]"));
        selectValueFromDropDown(expireDay, "15");
        WebElement expireYear = driver.findElement(By.name("form_data[prior_policy][_date_current_policy_expiration][year]"));
        selectValueFromDropDown(expireYear, "2021");


    // Insert info in "Years With Previous (or Current) Insuror" tag section:
        WebElement insurorStatus = driver.findElement(By.name("form_data[prior_policy][years_with_prior]"));
        String insurorYearStatus = "6";
        insurorStatus.click();
        insurorStatus.sendKeys(insurorYearStatus);

    // Insert info in "Years With Previous (or Current) Insuror" tag section:
        WebElement insurorContinuity = driver.findElement(By.name("form_data[prior_policy][years_with_continuous]"));
        String insurorContinuityStatus = "10";
        insurorContinuity.click();
        insurorContinuity.sendKeys(insurorContinuityStatus);


    // select value from "How Did You Hear About Us?" tag section:
        WebElement referralInfo = driver.findElement(By.name("form_data[additional_information][referral]"));
        String referralStatus = "Google";
        selectValueFromDropDown(referralInfo, referralStatus);


     // select value from "Preferred Contact Method" tag section:
        WebElement preferredContactWay = driver.findElement(By.name("form_data[additional_information][preferred_contact]"));
        String preferredContactMethod = "By Phone (Day)";
        selectValueFromDropDown(preferredContactWay, preferredContactMethod);

    // Insert Comments into "Additional Comments" tag section:
        WebElement comment = driver.findElement(By.name("form_data[additional_information][notes]"));
        String myComment = "_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_\n" +
                " This is my complete End to End automation testing for this website.\n" +
                "            _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_";
        comment.click();
        comment.sendKeys(myComment);

    //continue To Finish the process
        WebElement finishButton = driver.findElement(By.name("finish"));
        finishButton.click();
        System.out.println("Finished and Successfully submited");

     // Assert the Submit Conformation message
        WebElement conformationMessage = driver.findElement(By.id("main"));

        String actualConformationMessage =conformationMessage.getText();
        String expectedConformationMessage = "Thank You\n" +
                "Thank you for contacting Demo Insurance Agency.  A representative will contact you shortly regarding your submission.";
        Assert.assertEquals(actualConformationMessage,expectedConformationMessage );


        System.out.println("\"                           _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_\\n\" +\n" +
                "                \" Everything passed Successfully; End to End automation testing is Done \\n\" +\n" +
                "                \"            _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_\";");
    }









//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


// Method for handling Dropdown Menu
public static void selectValueFromDropDown(WebElement element, String value){
    Select select =new Select(element);
    select.selectByVisibleText(value);

}


}

