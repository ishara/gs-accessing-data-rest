package hello;
/*
 * Copyright (c) 2016. CodeGen Ltd. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Created by ishara on 8/24/2016 11:56 AM
 */

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestrictedClassFieldsRepository
{
    private Map<String, List<RestrictedFields>> list = new HashMap<>(  );


    public RestrictedClassFieldsRepository( )
    {
        String[] noPice = new String[]{"price"};
        String[] noCost = new String[]{"cost","bkgAdvNotes","clientId"};
        String[] returnData = new String[]{"returnData"};
        String[] name = new String[]{"firstName"};

        RestrictedFields restrictedFields1 = new RestrictedFields("it.codegen.tbx.central.test.dto.IBookingDTO",noCost);
        RestrictedFields restrictedFields3 = new RestrictedFields("it.codegen.tbx.central.test.dto.IItem",noCost);
        RestrictedFields restrictedFields4 = new RestrictedFields("it.codegen.tbx.central.test.dto.TestItem",noCost);
        RestrictedFields restrictedFields5 = new RestrictedFields("it.codegen.tbx.spi.reservationmanager.IBooking",noCost);
        //		RestrictedFields restrictedFields5 = new RestrictedFields("it.codegen.tbx.reservationmanager.Booking",noCost);
        RestrictedFields restrictedFields7 = new RestrictedFields("it.codegen.tbx.reservation.domain.PatchTestDomain",noCost);
        RestrictedFields restrictedFields8 = new RestrictedFields("hello.IPerson",name);


        List permList1 = new ArrayList(  );
        //		permList1.add( restrictedFields1 );

//        permList1.add( restrictedFields1 );
//        permList1.add( restrictedFields3 );
//        permList1.add( restrictedFields4 );
//        permList1.add( restrictedFields5 );
//        permList1.add( restrictedFields7 );
//        permList1.add( restrictedFields8 );

        list.put( "dontShowBookingCost" , permList1);

        List permList2 = new ArrayList(  );
        permList2.add( restrictedFields4 );

        list.put( "dontShowTestItemCost" , permList2);


    }

    /*public List<RestrictedFields> getRestrictedFields( GrantedAuthority grantedAuthority )
    {
        return list.get( grantedAuthority.getAuthority().toString() );
    }
*/
    public List<RestrictedFields> loadUserPermissionMapEx()
    {
        return list.get( "dontShowBookingCost" );
    }
    public Map<String, List<String>> getRestrictedFieldMap()
    {
        Map<String, List<String>> fieldsMap = new HashMap<>();
        for( RestrictedFields restrictedFieldse : loadUserPermissionMapEx() )
        {
            if( fieldsMap.containsKey( restrictedFieldse.getClassName() ) )
            {
                fieldsMap.get( restrictedFieldse.getClassName() ).addAll( Arrays.asList( restrictedFieldse.getRestrictedFields() ) );
            }
            else
            {
                List<String> strings = new ArrayList<>();
                strings.addAll( Arrays.asList( restrictedFieldse.getRestrictedFields() ) );
                fieldsMap.put( restrictedFieldse.getClassName(), strings );
            }
        }
        return fieldsMap;
    }
	/*public List<RestrictedFields> loadUserPermissionMap()
	{
		List<RestrictedFields> permissionMap = new ArrayList<>(  );
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
		for ( Iterator<? extends GrantedAuthority> iterator = grantedAuthorities.iterator(); iterator.hasNext(); )
		{
			GrantedAuthority grantedAuthority = iterator.next();
			permissionMap.addAll( loadRestrictedFields(grantedAuthority) );
		}
		return permissionMap;
	}

	private List<RestrictedFields> loadRestrictedFields( GrantedAuthority grantedAuthority )
	{
		return getRestrictedFields(grantedAuthority);
	}*/
}
