package clinicmanagement.model.entity;

import java.time.LocalDate;

public class Tool {
    private int id;
    private int roomId;
    private String name;
    private LocalDate importDate;
    private LocalDate expireDate;
    private String status;

    public Tool(int id, int roomId, String name, LocalDate importDate, LocalDate expireDate, String status) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
        this.importDate = importDate;
        this.expireDate = expireDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
