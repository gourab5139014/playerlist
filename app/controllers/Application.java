package controllers;

import play.*;
import play.mvc.*;
import models.*;
import views.html.*;	
import play.data.Form;
import play.data.DynamicForm;
import java.util.*;

public class Application extends Controller {
	//static Form<Player> playerForm = Form.form(Player.class);
	static Team t = new Team();
	private static final Form<Team> teamForm = Form.form(Team.class);
	
    public static Result index() {
       //return ok(index.render("Welcome to MySelector"));
	   return redirect(routes.Application.teamList());
    }
		
	public static Result players() {
		//return TODO;
		return ok(views.html.index.render(PlayerList.all()));
	}
	
	public static Result addPlayer(Long id) {
		System.err.println(" To add player no "+id);
		String response = t.addPlayer(id);
		if(response != null) { //Some error code
			System.err.println("CONTROLLER : Unable to add player due to "+response);
			flash("error","Chosen team type does not allow such a selection");
			return redirect(routes.Application.teamList());
		}
		flash("success","Player "+ t.getPlayerById(id).getName() +" added to your team");
		return redirect(routes.Application.teamList());
		//return TODO;
	}
	
	public static Result deletePlayer(Long id) {
		System.err.println(" CONTROLLER : To delete player no "+id);
		t.deletePlayer(id);
		flash("success","Player deleted from team");
		return redirect(routes.Application.teamList());
		//return TODO;
	}
	
	public static Result teamList(){
	    //return list of players in the current team here
	    Map<String, String> options = new HashMap<String, String>();
        options.put("1", "3 batsmen, 1 wicketkeeper, 2 all rounders, 2 bowlers");
        options.put("2", "4 batsmen, 1 wicketkeeper, 1 all rounders, 2 bowlers");
        options.put("3", "3 batsmen, 1 wicketkeeper, 1 all rounders, 3 bowlers");
		String teamEditableCSS = "none";
		if(t.isEditable()) teamEditableCSS = "inherit";
		System.err.println("Player movement is now "+teamEditableCSS);
		//TODO: Change to fetch option texts from TeamType member of Team object
	    return ok(views.html.team.render(t, teamEditableCSS,options, teamForm, t.getPlayers(),t.getAvailablePlayers()));
	    //eturn TODO;
	}
	
	public static Result setTeamEditable(boolean val) {
		System.err.println(" CONTROLLER : Setting team editable to "+val);
		//t.setEditable(val);
		return redirect(routes.Application.teamList());
	}
	
	public static Result save() {
	    System.err.println(" CONTROLLER : Invoked save team method");
	    //DynamicForm bindedForm = form().bindFromRequest();
	    Form<Team> bindedForm = teamForm.bindFromRequest();
	    Team boundTeam = bindedForm.get();
		String teamName = boundTeam.getTeamName();
		String teamTypeChoice = request().body().asFormUrlEncoded().get("teamTypeSelector")[0];
	    System.err.println("CONTROLLER : Team Name - "+teamName+" team type = "+teamTypeChoice);
	    t.setTeamName(teamName);
		t.setTeamType(Integer.parseInt(teamTypeChoice));
		t.setEditable(true);
		flash("success","Team "+teamName+" created. Now add players!");
		//Sytem.err.println("Received UserName "+bindedForm.get("userName")+" & TeamName "+bindedForm.get("teamName"));
	    return redirect(routes.Application.teamList());
	}
	
	public static Result reset() {
		t.reset();
		flash("welcome","Let us start right away..");
		return redirect(routes.Application.teamList());
		//return TODO;
	}

}
