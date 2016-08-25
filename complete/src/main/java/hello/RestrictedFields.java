package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 11:56 AM
 */

public class RestrictedFields
{
    private String className;
    private String[] restrictedFields;

    public RestrictedFields( String className, String[] restrictedFields )
    {
        this.className = className;
        this.restrictedFields = restrictedFields;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName( String className )
    {
        this.className = className;
    }

    public String[] getRestrictedFields()
    {
        return restrictedFields;
    }

    public void setRestrictedFields( String[] restrictedFields )
    {
        this.restrictedFields = restrictedFields;
    }
}
