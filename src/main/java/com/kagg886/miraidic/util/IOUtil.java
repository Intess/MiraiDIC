package com.kagg886.miraidic.util;

import java.io.*;

public class IOUtil {

    public static String getFilePath(String... folders) {
        StringBuilder builder = new StringBuilder();
        for (String folder : folders) {
            builder.append(folder);
            builder.append(File.separator);
        }
        return builder.substring(0,builder.length() - 1);
    }
    public static byte[] loadByteFromFile(String file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int by;
        while ((by = stream.read()) != -1) {
            output.write(by);
        }
        stream.close();
        output.close();
        return output.toByteArray();
    }

    public static String loadStringFromFile(String file) throws IOException {
        return new String(loadByteFromFile(file));
    }

    public static String loadStringFromFile(File file) throws IOException {
        return new String(loadByteFromFile(file.getAbsolutePath()),"UTF-8");
    }


    public static void writeByteToFile(String file,byte[] byt) throws IOException {
        FileOutputStream stream;
        try {
            stream = new FileOutputStream(file);
        } catch (IOException e) {
            File b = new File(file);
            b.getParentFile().mkdirs();
            if (!b.createNewFile()) {
                throw e;
            }
            writeByteToFile(file, byt);
            return;
        }
        stream.write(byt);
        stream.close();
    }

    public static void writeStringToFile(String file,String content) throws IOException {
        writeByteToFile(file, content.getBytes());
    }

    public static void writeStringToFile(File file,String content) throws IOException {
        writeByteToFile(file.getAbsolutePath(), content.getBytes());
    }

    public static String PrintException(Throwable e) {
        StringWriter writer = new StringWriter();
        PrintWriter pWriter = new PrintWriter(writer);
        e.printStackTrace(pWriter);
        return writer.toString();
    }
}
