package com.example.countryapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Result {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("result")
    @Expose
    private List<CountryModel> result;
    @SerializedName("extra")
    @Expose
    private List<Object> extra;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<CountryModel> getResult() {
        return result;
    }

    public void setResult(List<CountryModel> result) {
        this.result = result;
    }

    public List<Object> getExtra() {
        return extra;
    }

    public void setExtra(List<Object> extra) {
        this.extra = extra;
    }

}
