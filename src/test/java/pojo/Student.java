package pojo;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.LocalDate;
import java.util.Random;

import static java.lang.String.valueOf;
import static java.time.ZoneId.systemDefault;
import static java.time.format.DateTimeFormatter.ofPattern;

public class Student {

    private final String dateInPattern = "dd MMM yyyy";
    private final String dateOutPattern = "dd MMMM,yyyy";
    private String firstName;
    private String lastName;
    private String email;
    private int gender;
    private String mobileNum;
    private LocalDate birthDate;
    private String subjects;
    private int hobbies;
    private String address;
    private File icon;
    private String state;
    private String city;

    private String genderName;

    public Student( ) {
        Faker faker = new Faker( );
        StringBuilder mobileNum = new StringBuilder( );

        for (int i = 1; i <= 10; i++)
            mobileNum.append(new Random( ).nextInt(10));

        this.firstName = faker.name( ).firstName( );
        this.lastName = faker.name( ).lastName( );
        this.email = faker.internet( ).emailAddress( );
        this.gender = new Random( ).nextInt(3) + 1;
        this.mobileNum = valueOf(mobileNum);
        this.birthDate = faker.date( ).birthday(15, 55).toInstant( ).atZone(systemDefault( )).toLocalDate( );
        this.subjects = "e";
        this.hobbies = new Random( ).nextInt(3) + 1;
        this.address = faker.address( ).fullAddress( );
        //this.icon = new File(getProperty("icon.path"));
        this.state = "u";
        this.city = "l";
        genderName = null;
    }

    public Student(boolean b) {
        Faker faker = new Faker( );
        StringBuilder mobileNum = new StringBuilder( );
        for (int i = 1; i <= 10; i++)
            mobileNum.append(new Random( ).nextInt(10));
        this.firstName = faker.name( ).firstName( );
        this.lastName = faker.name( ).lastName( );
        this.gender = new Random( ).nextInt(3) + 1;
        this.mobileNum = valueOf(mobileNum);
        this.birthDate = null;
        genderName = null;
    }

    public String getFirstName( ) {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail( ) {
        return email;
    }

    public int getGender( ) {
        return gender;
    }

    public void setGender(String genderName) {
        this.genderName = genderName;
    }

    public String getMobileNum( ) {
        return mobileNum;
    }

    public LocalDate getBirthDate( ) {
        return birthDate;
    }

    public String getBirthDateIn( ) {
        return getBirthDate( ).format(ofPattern(dateInPattern));
    }

    public String getBirthDateOut( ) {
        return getBirthDate( ).format(ofPattern(dateOutPattern));
    }

    public String getSubjects( ) {
        return subjects;
    }

    public int getHobbies( ) {
        return hobbies;
    }

    public String getAddress( ) {
        return address;
    }

    public File getIcon( ) { return icon; }

    public String getState( ) {
        return state;
    }

    public String getCity( ) {
        return city;
    }

    public String getGenderName( ) {
        return genderName;
    }

    @Override
    public String toString( ) {
        return "Student{" +
                "dateInPattern='" + dateInPattern + '\'' +
                ", dateOutPattern='" + dateOutPattern + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", mobileNum='" + mobileNum + '\'' +
                ", birthDate=" + birthDate +
                ", subjects='" + subjects + '\'' +
                ", hobbies=" + hobbies +
                ", address='" + address + '\'' +
                ", icon=" + icon +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", genderName='" + genderName + '\'' +
                '}';
    }

    public void setMobileNum(String mob) {
        mobileNum=mob;
    }

    public void setHobbies(int i) {
        hobbies=i;
    }
}