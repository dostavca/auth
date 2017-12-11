package si.dostavca.auth;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clani",
        "opis_projekta",
        "mikrostoritve",
        "github",
        "travis",
        "dockerhub"
})

public class Demo{

    @JsonProperty("clani")
    private List<String> clani = null;
    @JsonProperty("opis_projekta")
    private String opisProjekta;
    @JsonProperty("mikrostoritve")
    private List<String> mikrostoritve = null;
    @JsonProperty("github")
    private List<String> github = null;
    @JsonProperty("travis")
    private List<String> travis = null;
    @JsonProperty("dockerhub")
    private List<String> dockerhub = null;

    public Demo() {
        clani = new ArrayList<>();
        clani.add("zo4120");
        clani.add("ab4468");

        opisProjekta = "Inovativen način dostave, ki omogoča hiter in enostaven prevoz paketov, prtljage in drugih malenkosti";

        mikrostoritve = new ArrayList<>();
        mikrostoritve.add("http://35.195.253.165:8080");
        mikrostoritve.add("http://35.195.147.163:8081");

        github = new ArrayList<>();
        github.add("https://github.com/dostavca/dostavca-auth");
        github.add("https://github.com/dostavca/dostavca-profile");

        travis = new ArrayList<>();
        travis.add("https://travis-ci.org/dostavca/dostavca-auth");
        travis.add("https://travis-ci.org/dostavca/dostavca-profile");

        dockerhub = new ArrayList<>();
        dockerhub.add("https://hub.docker.com/r/zanozbot/dostavca-auth/");
        dockerhub.add("https://hub.docker.com/r/aljazb/dostavca-profile/");
    }

    @JsonProperty("clani")
    public List<String> getClani() {
        return clani;
    }

    @JsonProperty("clani")
    public void setClani(List<String> clani) {
        this.clani = clani;
    }

    @JsonProperty("opis_projekta")
    public String getOpisProjekta() {
        return opisProjekta;
    }

    @JsonProperty("opis_projekta")
    public void setOpisProjekta(String opisProjekta) {
        this.opisProjekta = opisProjekta;
    }

    @JsonProperty("mikrostoritve")
    public List<String> getMikrostoritve() {
        return mikrostoritve;
    }

    @JsonProperty("mikrostoritve")
    public void setMikrostoritve(List<String> mikrostoritve) {
        this.mikrostoritve = mikrostoritve;
    }

    @JsonProperty("github")
    public List<String> getGithub() {
        return github;
    }

    @JsonProperty("github")
    public void setGithub(List<String> github) {
        this.github = github;
    }

    @JsonProperty("travis")
    public List<String> getTravis() {
        return travis;
    }

    @JsonProperty("travis")
    public void setTravis(List<String> travis) {
        this.travis = travis;
    }

    @JsonProperty("dockerhub")
    public List<String> getDockerhub() {
        return dockerhub;
    }

    @JsonProperty("dockerhub")
    public void setDockerhub(List<String> dockerhub) {
        this.dockerhub = dockerhub;
    }

}
