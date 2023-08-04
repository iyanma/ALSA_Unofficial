package com.example.alsaunofficial.API;

import com.example.alsaunofficial.Models.JourneyResponse;
import com.example.alsaunofficial.Models.Origin;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface AlsaService {

    @Headers({
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/114.0.0.0 Safari/537.3"
    })
    @GET("/web/bus/checkout")
    Call<Void> searchJourneys(
            @Query("p_p_id") String p_p_id,
            @Query("p_p_lifecycle") String p_p_lifecycle,
            @Query("p_p_state") String p_p_state,
            @Query("p_p_mode") String p_p_mode,
            @Query("_PurchasePortlet_WAR_Alsaportlet_javax.portlet.action") String portlet_action,
            @Query("p_auth") String p_auth,
            @Query("code") String code,
            @Query("serviceType") String serviceType,
            @Query("accessible") String accessible,
            @Query("_JourneySearchPortlet_WAR_Alsaportlet_INSTANCE_JourneySearch_21651890_originStationNameId") String originStationNameId,
            @Query("originStationId") String originStationId,
            @Query("originStationSimplifiedName") String originStationSimplifiedName,
            @Query("originStationIsMoveliaStop") String originStationIsMoveliaStop,
            @Query("destinationStationId") String destinationStationId,
            @Query("destinationStationSimplifiedName") String destinationStationSimplifiedName,
            @Query("destinationStationIsMoveliaStop") String destinationStationIsMoveliaStop,
            @Query("departureDate") String departureDate,
            @Query("_departureDate") String _departureDate,
            @Query("returnDate") String returnDate,
            @Query("_returnDate") String _returnDate,
            @Query("locationMode") String locationMode,
            @Query("passengerType-1") String passengerType1,
            @Query("passengerType-4") String passengerType4,
            @Query("passengerType-5") String passengerType5,
            @Query("passengerType-2") String passengerType2,
            @Query("passengerType-3") String passengerType3,
            @Query("youngPromoCode") String youngPromoCode,
            @Query("promoCode") String promoCode,
            @Query("jsonAlsaPassPassenger") String jsonAlsaPassPassenger,
            @Query("jsonVoucherPassenger") String jsonVoucherPassenger,
            @Query("numPassengers") String numPassengers,
            @Query("regionalZone") String regionalZone,
            @Query("travelType") String travelType,
            @Query("LIFERAY_SHARED_isTrainTrip") String isTrainTrip,
            @Query("LIFERAY_SHARED_isRoundTrip") String isRoundTrip,
            @Query("LIFERAY_SHARED_isShipTrip") String isShipTrip,
            @Query("LIFERAY_SHARED_destinationStationIdIcon") String destinationStationIdIcon
    );

    @Headers({
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/114.0.0.0 Safari/537.3"
    })
    @GET("/web/bus/checkout?_PurchasePortlet_WAR_Alsaportlet_journeyDirection=outward" +
            "&p_p_resource_id=JsonGetJourneysList" +
            "&p_p_lifecycle=2" +
            "&p_p_id=PurchasePortlet_WAR_Alsaportlet")
    Call<JourneyResponse> getJourneysList();

    @Headers({
            "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/114.0.0.0 Safari/537.3"
    })
    @GET("/c/portal/layout" +
            "?p_l_id=21651890" +
            "&p_p_id=JourneySearchPortlet_WAR_Alsaportlet_INSTANCE_JourneySearch_21651890" +
            "&p_p_lifecycle=2" +
            "&p_p_resource_id=JsonGetOrigins" +
            "&_=1689254603150")
    Call<List<Origin>> getOrigins();
}
