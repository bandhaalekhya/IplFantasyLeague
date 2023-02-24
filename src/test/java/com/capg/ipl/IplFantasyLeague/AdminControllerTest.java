//package com.capg.ipl.IplFantasyLeague;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.capg.ipl.controller.AdminController;
//import com.capg.ipl.entity.Admin;
//
//import com.capg.ipl.entity.MatchDetails;
//import com.capg.ipl.entity.Team;
//import com.capg.ipl.exception.InvalidAdminException;
//import com.capg.ipl.exception.MatchAlreadyInProgressException;
//import com.capg.ipl.exception.MatchNotFoundException;
//import com.capg.ipl.exception.TeamNotFoundException;
//import com.capg.ipl.service.AdminService;
//@RunWith(MockitoJUnitRunner.class)
//public class AdminControllerTest {
//@Mock
//private AdminService adminService;
//@InjectMocks
//private AdminController adminController;
//
//@Test
//public void testRegisterAdmin() throws Exception {
//    Admin admin = new Admin();
//    when(adminService.registerAdmin(any(Admin.class))).thenReturn(admin);
//    Admin result = adminController.registerAdmin(admin);
//    assertEquals(admin,result);
//}
//@Test
//public void testLoginAdmin() throws InvalidAdminException {
//    Admin admin = new Admin();
//    admin.setUsername("admin");
//    admin.setPassword("password");
//    when(adminService.loginAdmin(admin)).thenReturn("Successful Login");
//    assertEquals("Successful Login", adminController.loginAdmin(admin));
//}
//@Test
//public void testAddTeam() throws Exception {
//	Team team = new Team();
//	when(adminService.addTeam(any(Team.class))).thenReturn(team);
//	ResponseEntity<String> response = adminController.addTeam(team);
//	assertEquals("Team added Successfully", response.getBody());
//}
//@Test
//public void testAddMatch() throws Exception {
//	MatchDetails matchDetails = new MatchDetails();
//	when(adminService.addMatchDetails(any(MatchDetails.class))).thenReturn(matchDetails);
//	ResponseEntity<String> response = adminController.addMatchDetails(matchDetails);
//	assertEquals("Match added", response.getBody());
//}
//
//@Test
//public void testDeleteTeam() throws TeamNotFoundException{
//	long teamId=1L;
//	doNothing().when(adminService).deleteTeam(teamId);
//	ResponseEntity<String> response=adminController.deleteTeam(teamId);
//	assertEquals(HttpStatus.OK,response.getStatusCode());
//	assertEquals("Team Deleted Successfully",response.getBody());
//}
//@Test
//public void testDeleteMatchById() throws MatchNotFoundException, MatchAlreadyInProgressException{
//	long matchId=1L;
//	doNothing().when(adminService).deleteMatchById(matchId);
//	ResponseEntity<String> response=adminController.deleteMatchById(matchId);
//	assertEquals(HttpStatus.OK,response.getStatusCode());
//	assertEquals("Match Deleted",response.getBody());
//}
//}