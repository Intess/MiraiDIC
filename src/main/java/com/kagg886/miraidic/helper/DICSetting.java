package com.kagg886.miraidic.helper;

public class DICSetting {
    private String name;
    private String description;
    private String version;

    private String author;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public DICSetting(String module) {
        String[] units = module.split("\n");
        for (String unit : units) {
            String[] unitFormat = unit.split(":");
            if (unitFormat.length < 2) {
                return;
            }
            if (unitFormat[0].equals("名称")) {
                name = unitFormat[1];
                continue;
            }
            if (unitFormat[0].equals("描述")) {
                description = unitFormat[1];
                continue;
            }

            if (unitFormat[0].equals("版本")) {
                version = unitFormat[1];
                continue;
            }

            if (unitFormat[0].equals("作者")) {
                author = unitFormat[1];
            }
        }
    }
}
