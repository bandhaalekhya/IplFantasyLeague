package com.capg.ipl.IplFantasyLeague;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capg.ipl.controller.BidderController;
import com.capg.ipl.entity.Bidder;
import com.capg.ipl.entity.BiddingDetails;
import com.capg.ipl.entity.MatchDetails;
import com.capg.ipl.entity.Team;
import com.capg.ipl.service.BidderService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class BidderControllerTest {
    
    @Mock
    private BidderService bidderService;
    
    @InjectMocks
    private BidderController bidderController;
    
    @Test
    public void testRegisterBidder() throws Exception {
        Bidder bidder = new Bidder();
        when(bidderService.registerBidder(any(Bidder.class))).thenReturn(bidder);
        Bidder result = bidderController.registerBidder(bidder);
        assertEquals(bidder,result);
    }
    
    @Test
    public void testBidderLogin() throws Exception {
        Bidder bidder = new Bidder();
        when(bidderService.bidderLogin(any(Bidder.class))).thenReturn("Success");
        String result = bidderController.bidderLogin(bidder);
        assertEquals("Success", result);
    }
    
    @Test
    public void testAddBid() throws Exception {
        BiddingDetails biddingDetails = new BiddingDetails();
        when(bidderService.addBid(any(BiddingDetails.class))).thenReturn(biddingDetails);
        BiddingDetails result = bidderController.addBid(biddingDetails);
        assertEquals(biddingDetails, result);
    }
    
    @Test
    public void testUpdateBid() throws Exception {
        doNothing().when(bidderService).updateBid(anyLong(),anyLong(), anyLong());
        ResponseEntity<String> result = bidderController.updateBid(1L, 2L, 3L);
        assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
    }
    
    @Test
    public void testDeleteBid() throws Exception {
        doNothing().when(bidderService).deleteBid(anyLong());
        ResponseEntity<String> result = bidderController.deleteBid(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
    
    @Test
    public void testGetResult() throws Exception {
        long matchId = 1L;
        String expectedResult = "Team A won the match";
        when(bidderService.getResult(matchId)).thenReturn(expectedResult);
        String actualResult = bidderController.getResult(matchId);
        assertEquals(expectedResult, actualResult);
    }
     
    @Test
    public void testGetPoints() throws  Exception{
        long bidderId = 1;
        int expectedPoints = 50;
        Bidder bidder = new Bidder();
        when(bidderService.viewPoints(bidderId)).thenReturn(expectedPoints);
        int actualPoints = bidderController.getPoints(bidderId);
        assertEquals(expectedPoints, actualPoints);
    }
    @Test
    public void testViewAllMatches() throws Exception {
        List<MatchDetails> expectedMatches = Arrays.asList(
            new MatchDetails(),
            new MatchDetails()
        );
        Mockito.when(bidderService.viewAllMatches()).thenReturn(expectedMatches);
        List<MatchDetails> actualMatches = bidderController.viewAllMatches();
        Assert.assertEquals(expectedMatches, actualMatches);
        }
    @Test
          public void TestGetTeamById() throws Exception {
            Team team = new Team();
            team.setTeamId(1L);
             team.setTeamName("Test Team");
}
}