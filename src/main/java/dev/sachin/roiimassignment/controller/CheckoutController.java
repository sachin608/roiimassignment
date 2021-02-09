package dev.sachin.roiimassignment.controller;

import dev.sachin.roiimassignment.dto.MakePaymentDTOs.MakePaymentRequestDTO;
import dev.sachin.roiimassignment.dto.MakePaymentDTOs.MakePaymentResponseDTO;
import dev.sachin.roiimassignment.dto.ResponseDTO;
import dev.sachin.roiimassignment.dto.SingleUseCustomerTokenDTOs.SingleUseCustomerTokenResponseDTO;
import dev.sachin.roiimassignment.repository.CustomerRepository;
import dev.sachin.roiimassignment.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckoutController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CheckoutService checkoutService;

    public CheckoutController(){}

    /*
    public CheckoutController( CustomerRepository customerRepository ){
        this.customerRepository = customerRepository;
        //this.checkoutService = checkoutService;
    }*/

    @GetMapping( "/SingleUseCustomerToken/{emailId}" )
    public ResponseDTO getSingleUseCustomerToken(@PathVariable String emailId ){

        //CheckoutService checkoutService = new CheckoutService();
        ResponseDTO<SingleUseCustomerTokenResponseDTO> responseDTO = new ResponseDTO< SingleUseCustomerTokenResponseDTO >();
        responseDTO.setStatus( HttpStatus.OK );
        responseDTO.setMessage( "SingleUseCustomerToken Created" );
        responseDTO.setData( checkoutService.creatSingleUserCustomerToken( emailId ) );
        return responseDTO;
    }

    @PostMapping( "/MakePayment/{emailId}" )
    public ResponseDTO makePayment(@PathVariable String emailId, @RequestBody MakePaymentRequestDTO makePaymentRequestDTO ){

        ResponseDTO<MakePaymentResponseDTO> responseDTO = new ResponseDTO<MakePaymentResponseDTO>();
        responseDTO.setStatus( HttpStatus.OK );
        responseDTO.setMessage( "Payment Done Successfully" );
        responseDTO.setData( checkoutService.makePayment( makePaymentRequestDTO ) );
        return responseDTO;
    }
}
