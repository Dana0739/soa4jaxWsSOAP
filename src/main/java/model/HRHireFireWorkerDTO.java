package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "export")
@XmlAccessorType(XmlAccessType.FIELD)
public class HRHireFireWorkerDTO implements Serializable {

    Long organizationId;

    Position position;

    Status status;

    Date startDate;

    Date endDate;

    public HRHireFireWorkerDTO() {
        this.endDate = new Date();
    }

    public HRHireFireWorkerDTO(Long orgId, Position position, Status status, Date startDate) {
        this.organizationId = orgId;
        this.position = position;
        this.status = status;
        this.startDate = startDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @XmlElement
    public Status getStatus() {
        return status;
    }

    @XmlElement
    public Position getPosition() {
        return position;
    }

    @XmlElement
    public Date getEndDate() {
        return endDate;
    }

    @XmlElement
    public Date getStartDate() {
        return startDate;
    }

    @XmlElement
    public Long getOrganizationId() {
        return organizationId;
    }
}
