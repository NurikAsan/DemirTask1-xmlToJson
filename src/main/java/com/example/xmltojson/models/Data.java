package com.example.xmltojson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement(localName = "Data")
public class Data {
    @JacksonXmlProperty(localName = "Method")
    @JsonProperty("Method")
    private Method method;

    @JacksonXmlProperty(localName = "Process")
    @JsonProperty("Process")
    private Process process;

    @JsonProperty("Layer")
    private String layer;

    @JsonProperty("Creation")
    private Creation creation;

    @JsonProperty("Type")
    private String type;

    @Getter
    @Setter
    public static class Method {

        @JacksonXmlProperty(localName = "Name")
        @JsonProperty("Name")
        private String name;

        @JacksonXmlProperty(localName = "Type")
        @JsonProperty("Type")
        private String type;

        @JacksonXmlProperty(localName = "Assembly")
        @JsonProperty("Assembly")
        private String assembly;
    }

    @Getter
    @Setter
    public static class Process {

        @JacksonXmlProperty(localName = "Name")
        @JsonProperty("Name")
        private String name;

        @JacksonXmlProperty(localName = "Id")
        @JsonProperty("Id")
        private String id;

        @JacksonXmlProperty(localName = "Start")
        @JsonProperty("Start")
        private Start start;

        @Getter
        @Setter
        public static class Start {

            @JacksonXmlProperty(localName = "Epoch")
            @JsonProperty("Epoch")
            private String epoch;

            @JacksonXmlProperty(localName = "Date")
            @JsonProperty("Date")
            private String date;
        }
    }

    @Getter
    @Setter
    public static class Creation {

        @JacksonXmlProperty(localName = "Epoch")
        @JsonProperty("Epoch")
        private String epoch;

        @JacksonXmlProperty(localName = "Date")
        @JsonProperty("Date")
        private String date;
    }
}
