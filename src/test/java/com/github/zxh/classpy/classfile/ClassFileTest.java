package com.github.zxh.classpy.classfile;

import com.github.zxh.classpy.TestClass;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassFileTest {
    
    @Test
    public void read() throws Exception {
        String classFileName = TestClass.class.getName().replace('.', '/') + ".class";
        Path classFilePath = Paths.get(TestClass.class.getClassLoader().getResource(classFileName).toURI());
        byte[] classBytes = Files.readAllBytes(classFilePath);
        
        ClassFile cf = ClassFile.parse(classBytes);
        assertEquals(0, cf.getMinorVersion().getValue());
        assertEquals(52, cf.getMajorVersion().getValue());
        assertEquals(33, cf.getConstantPoolCount().getValue());
        assertEquals(2, cf.getInterfacesCount().getValue());
        assertEquals(2, cf.getFieldsCount().getValue());
    }
    
}