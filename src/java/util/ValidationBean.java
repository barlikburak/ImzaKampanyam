package util;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@SessionScoped
public class ValidationBean implements Serializable {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = value.toString();
        if (str.length() < 2) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "en az 2 karakter"));
        }
        if (str.length() > 100) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "en fazla 100 karakter"));
        }
    }

    public void validateSartOnay(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        boolean bool = Boolean.valueOf(value.toString());
        if (!bool) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "summary", "Hizmet şartlarını ve Gizlilik politikasını kabul edin."));
        }
    }

}
