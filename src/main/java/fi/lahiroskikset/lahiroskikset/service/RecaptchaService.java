package fi.lahiroskikset.lahiroskikset.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecaptchaService {

    @Value("${RECAPTCHA_SECRET_KEY}")
    private String recaptchaSecretKey;

    public boolean verifyRecaptcha(String recaptchaToken) {
        final String url = "https://www.google.com/recaptcha/api/siteverify";
        final String params = "?secret=" + recaptchaSecretKey + "&response=" + recaptchaToken;

        RestTemplate restTemplate = new RestTemplate();
        RecaptchaResponse response = restTemplate.postForObject(url + params, null, RecaptchaResponse.class);

        return response != null && response.isSuccess();
    }

    private static class RecaptchaResponse {
        private boolean success;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }
}