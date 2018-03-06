package edu.objects;

public final class IocCode implements Comparable<IocCode> {

    private String id;
    private String code;
    private String countryName;
    private int year;

    /**
     * 
     * @param id
     *            The ID of the IOC - Code
     * @param code
     *            the code of the IOC - Code
     * @param countryName
     *            the country name of the respective IOC - Code
     * @param year
     *            the year of establishment of the IOC - Code
     */
    public IocCode(String id, String code, String countryName, int year) {
        this.id = id;
        this.code = code;
        this.countryName = countryName;
        this.year = year;
    }

    /**
     * 
     * @return The ID of the IOC - Code
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return the code of the IOC - Code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @return the country name of the respective IOC - Code
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * @return the year of establishment of the IOC - Code
     */
    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(IocCode i) {
        if (this.getYear() < i.getYear()) {
            return -1;
        } else if (this.getYear() > i.getYear()) {
            return 1;
        } else {
            if (Integer.parseInt(this.getId()) < Integer.parseInt(i.getId())) {
                return -1;
            } else if (Integer.parseInt(this.getId()) > Integer.parseInt(i.getId())) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
