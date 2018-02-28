package edu.objects;

public final class IocCode implements Comparable<IocCode> {

    private String id;
    private String code;
    private String countryName;
    private int year;

    public IocCode(String id, String code, String countryName, int year) {
        this.id = id;
        this.code = code;
        this.countryName = countryName;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCountryName() {
        return countryName;
    }

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
