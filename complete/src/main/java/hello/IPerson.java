package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 10:55 AM
 */


import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonFilter("authorityFilter")
public interface IPerson
{
    public long getId();

    public String getFirstName();

    public void setFirstName( String firstName );
}
