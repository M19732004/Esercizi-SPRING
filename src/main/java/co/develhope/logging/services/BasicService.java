package co.develhope.logging.services;

import org.springframework.stereotype.Service;

@Service
public class BasicService {
    public Integer[] n1_n2_power(int n1,int n2){
        Integer[] n1pow_n2pow_array={n1*n1,n2*n2};
        return n1pow_n2pow_array;
    }
}