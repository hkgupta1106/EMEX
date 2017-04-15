package model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * student details model class
 */
public class JobHistoryModel implements Parcelable {


    public static final Creator<JobHistoryModel> CREATOR = new Creator<JobHistoryModel>() {
        @Override
        public JobHistoryModel createFromParcel(final Parcel in) {
            return new JobHistoryModel(in);
        }

        @Override
        public JobHistoryModel[] newArray(final int size) {
            return new JobHistoryModel[size];
        }
    };

    private String name;
    private String pickUpAddress;
    private String date;
    private String kiloMeter;
    private String rideTime;
    private String ammount;
    private String destinationAddress;

    /**
     *
     * @param name driver name
     * @param pickUpAddress pick up address
     * @param date date
     * @param kiloMeter distance
     */
    public JobHistoryModel(final String name, final String pickUpAddress, final String date, final String kiloMeter) {
        this.name = name;
        this.pickUpAddress = pickUpAddress;
        this.date = date;
        this.kiloMeter = kiloMeter;
    }

    /**
     *
     * @param name driver name
     * @param pickUpAddress pick up address
     * @param date date
     * @param kiloMeter distance
     * @param destinationAddress destination address
     * @param ammount price
     * @param rideTime ride time
     */
    public JobHistoryModel(final String name, final String pickUpAddress, final String date, final String kiloMeter,
                           final String destinationAddress, final String ammount, final String rideTime) {
        this.name = name;
        this.pickUpAddress = pickUpAddress;
        this.date = date;
        this.kiloMeter = kiloMeter;
        this.destinationAddress = destinationAddress;
        this.ammount = ammount;
        this.rideTime = rideTime;
    }


    /**
     *
     * @param in asd
     */
    protected JobHistoryModel(final Parcel in) {
        name = in.readString();
        pickUpAddress = in.readString();
        date = in.readString();
        kiloMeter = in.readString();
        destinationAddress = in.readString();
        rideTime = in.readString();
        ammount = in.readString();
    }
    /**
     *
     * @return getting ride time
     */
    public String getRideTime() {
        return rideTime;
    }

    /**
     *
     * @param rideTime setting ride time
     */
    public void setRideTime(final String rideTime) {
        this.rideTime = rideTime;
    }


    /**
     *
     * @return getting ammount
     */
    public String getAmmount() {
        return ammount;
    }

    /**
     *
     * @param ammount setting ammount
     */
    public void setAmmount(final String ammount) {
        this.ammount = ammount;
    }


    /**
     *
     * @return getting destination address
     */
    public String getDestinationAddress() {
        return destinationAddress;
    }

    /**
     *
     * @param destinationAddress setting destination address
     */
    public void setDestinationAddress(final String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
    /**
     *
     * @return getting driver name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name setting name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return getting pick up address
     */
    public String getPickUpAddress() {
        return pickUpAddress;
    }

    /**
     *
     * @param pickUpAddress setting address
     */
    public void setPickUpAddress(final String pickUpAddress) {
        this.pickUpAddress = pickUpAddress;
    }

    /**
     *
     * @return getting date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date setting date
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     *
     * @return getting distance
     */
    public String getKiloMeter() {
        return kiloMeter;
    }

    /**
     *
     * @param kiloMeter setting distance
     */
    public void setKiloMeter(final String kiloMeter) {
        this.kiloMeter = kiloMeter;
    }

    /**
     *
     * @return creater constructor
     */
    public static Creator<JobHistoryModel> getCREATOR() {
        return CREATOR;
    }

    /**
     *
     * @param dest asd
     * @param flags asd
     */
    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(name);
        dest.writeString(pickUpAddress);
        dest.writeString(date);
        dest.writeString(kiloMeter);
        dest.writeString(destinationAddress);
        dest.writeString(ammount);
        dest.writeString(rideTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}