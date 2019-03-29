package models;

import java.math.BigDecimal;

public class MapLocation
{
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String url;

    public BigDecimal getLatitude()
    {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude)
    {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude()
    {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude)
    {
        this.longitude = longitude;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
