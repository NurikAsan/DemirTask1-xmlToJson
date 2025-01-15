package com.example.xmltojson.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

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

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public Creation getCreation() {
        return creation;
    }

    public void setCreation(Creation creation) {
        this.creation = creation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAssembly() {
            return assembly;
        }

        public void setAssembly(String assembly) {
            this.assembly = assembly;
        }
    }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Start getStart() {
            return start;
        }

        public void setStart(Start start) {
            this.start = start;
        }

        public static class Start {

            @JacksonXmlProperty(localName = "Epoch")
            @JsonProperty("Epoch")
            private String epoch;

            @JacksonXmlProperty(localName = "Date")
            @JsonProperty("Date")
            private String date;

            public String getEpoch() {
                return epoch;
            }

            public void setEpoch(String epoch) {
                this.epoch = epoch;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }

    public static class Creation {

        @JacksonXmlProperty(localName = "Epoch")
        @JsonProperty("Epoch")
        private String epoch;

        @JacksonXmlProperty(localName = "Date")
        @JsonProperty("Date")
        private String date;

        public String getEpoch() {
            return epoch;
        }

        public void setEpoch(String epoch) {
            this.epoch = epoch;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
