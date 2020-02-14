package com.developer.tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BTreeService {
    public static void main(String[] args) throws JsonProcessingException {
        List<Employee>  rawData=  fetchRawDataFromDB();
        Employee root=createB_Plus_Tree(rawData);
        System.out.println(new ObjectMapper().writeValueAsString(root));
    }

    private static Employee createB_Plus_Tree(List<Employee> nodes) {
        Map<Integer,Employee> mapTemp=new HashMap<>();
        //save all nodes to a map
        for(Employee emp:nodes){
            mapTemp.put(emp.getId(),emp);
        }
        //loop and assign parent and child relationship
        for(Employee current:nodes){
           Integer parentId= current.getReportingId();
           if(parentId!=null){
               Employee parent= mapTemp.get(parentId);
               if(parent!=null){
                   parent.addChild(current);
                   mapTemp.put(parentId,parent);
                   mapTemp.put(current.getId(),current);
               }
           }
        }
        //get root
        Employee root=null;
        for(Employee emp:mapTemp.values()){
            if(emp.getReportingId()==null){
                root=emp;
                break;
            }
        }
        return root;
    }

    private static  List<Employee> fetchRawDataFromDB(){
        Employee subbu =new Employee(1,"SUBBU","C.E.O",200000.0,null);
        Employee ranga =new Employee(2,"RANGA","MANAGER",200000.0,1);
        Employee kiran =new Employee(3,"KIRAN","MANAGER",3333333.1,1);
        Employee raju =new Employee(4,"RAJU","TEAM LEAD",11111111.1,1);
        Employee mohan =new Employee(5,"MOHAN","TEAM LEAD",77777777.7,2);
        Employee chandra =new Employee(6,"CHANDRA","TEAM LEAD",77777777.7,2);
        Employee kanth =new Employee(7,"KANTH","DEVELOPER",666666666.6,4);
        Employee mani =new Employee(8,"MANI","DEVELOPER",8888888888.8,4);
        Employee hari =new Employee(9,"HARI","DEVELOPER",44444444444.4,5);
        return Arrays.asList(subbu,ranga,kiran,raju,mohan,chandra,kanth,mani,hari);

    }
}
