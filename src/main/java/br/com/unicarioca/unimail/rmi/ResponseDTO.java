package br.com.unicarioca.unimail.rmi;

import java.io.Serializable;

/**
 * Created by alessandro.santos on 11/15/16.
 */
public class ResponseDTO implements Serializable {

    private String status;

    public ResponseDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResponseDTO{");
        sb.append("status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
