package com.softserve2020practice.models.enums;

import lombok.SneakyThrows;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class EnumRole implements UserType, ParameterizedType {

    private Method recreateEnumMthd;

    private Method recreateStringMthd;

    private Class enumClass;

    @Override
    @SneakyThrows
    public void setParameterValues(Properties properties) {

        if (properties != null) {
            String enumMthd = properties.getProperty("recreateEnumMthd");
            String strMthd = properties.getProperty("recreateStringMthd");
            String className = properties.getProperty("enumClassName");
            Class<?> returnType = null;

            enumClass = Class.forName(className);
            recreateStringMthd = enumClass.getMethod(strMthd, new Class[]{});
            returnType = recreateStringMthd.getReturnType();
            recreateEnumMthd = enumClass.getMethod(enumMthd, new Class[]{returnType});
        }
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.CHAR};
    }

    @Override
    public Class returnedClass() {
        //return GenderEnum.class;
        return enumClass;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return ObjectUtils.nullSafeEquals(o, o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    @SneakyThrows
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        String value = rs.getString(names[0]);
        Object returnVal = null;

        if (value == null)
            return null;
        else {
            returnVal = recreateEnumMthd.invoke(enumClass, new Object[]{value});
        }
        //return (GenderEnum)returnVal;
        return returnVal;
    }

    @Override
    @SneakyThrows
    public void nullSafeSet(PreparedStatement st, Object o, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        String prepStmtVal = null;

        if (o == null) {
            st.setObject(index, null);
        } else {
            prepStmtVal = (String) recreateStringMthd.invoke(o, new Object[]{});
            st.setString(index, prepStmtVal);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        if (o == null)
            return null;
        else {
            Role enumVal = (Role) o;
            return Role.recreateEnum(enumVal.getValue());
        }
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        Object deepCopy = deepCopy(o);

        if (!(deepCopy instanceof Serializable))
            return (Serializable) deepCopy;

        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}
