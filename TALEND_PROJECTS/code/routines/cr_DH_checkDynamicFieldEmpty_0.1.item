package routines;

import routines.system.Dynamic;
//import routines.system.DynamicMetadata;


public class cr_DH_checkDynamicFieldEmpty {

    /**
     * cr_DH_checkDynamicFieldEmpty: return true or false value.
     * 
     * 
     * {talendTypes} Boolean
     * 
     * {Category} User Defined
     * 
     * {param} DynamicColumn("newColumn") input: The dynamic column need to be checked.
     * 
     * {example} checkFieldEmpty(input_row.newColumn1) # true !.
     */
    public static Boolean checkFieldEmpty(Dynamic field_in) {
    	Dynamic columns = field_in;
    	String fieldEmptyFlag = "";
    	
    	for (int i = 0; i < columns.getColumnCount(); i++) {
    	//  DynamicMetadata columnMetadata = columns.getColumnMetadata(i);
    	   fieldEmptyFlag = Relational.ISNULL(columns.getColumnValue(i))?"1":"0";
    	//   System.out.println(columnMetadata.getName() + ": " + field_in);
    //	   System.out.println("fieldEmptyFlag: " + fieldEmptyFlag);
    	}
    	/* 
    	 * Returns true for valid value
    	 */
    if(fieldEmptyFlag=="0")
    	return true;
    else 
    	return false;
    }
}
