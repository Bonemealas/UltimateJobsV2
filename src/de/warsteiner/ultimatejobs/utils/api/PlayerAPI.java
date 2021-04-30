package de.warsteiner.ultimatejobs.utils.api;

import java.util.ArrayList;
import java.util.List;

import de.warsteiner.ultimatejobs.UltimateJobs;
import de.warsteiner.ultimatejobs.utils.data.PlayerJobDataFile;

public class PlayerAPI {
	
	public void createPlayer(String uuid) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
 
		cl.load();
		
		cl.get().set("Player."+uuid+".CurrentJob", list);
		cl.get().set("Player."+uuid+".OwnsJob", list2);
		cl.get().set("Player."+uuid+".MaxJobs", UltimateJobs.getMainConfig().getInt("MaxJobsDefault"));
		
		cl.save(); 
	}
	
	public void createJob(String uuid, String job) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
 
		cl.load();
 
		cl.get().set("Job."+uuid+".ID."+job+".Level", 1);
		cl.get().set("Job."+uuid+".ID."+job+".Exp", 1);
		cl.get().set("Job."+uuid+".ID."+job+".Count1", 0);
		cl.get().set("Job."+uuid+".ID."+job+".Count2", 0);
		cl.get().set("Job."+uuid+".ID."+job+".Count3", 0);
		cl.get().set("Job."+uuid+".ID."+job+".Count4", 0);
		cl.get().set("Job."+uuid+".ID."+job+".Count5", 0);
		cl.save(); 
	}
	
	public boolean isInJob(String uuid, String id) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		return cl.get().getStringList("Player."+uuid+".CurrentJob").contains(id); 
	}
	
	public void addOwnJob(String uuid, String job) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		List<String> b = cl.get().getStringList("Player."+uuid+".OwnsJob");
		b.add(job);
		cl.get().set("Player."+uuid+".OwnsJob", b);
		cl.save();
	}
	
	public void addCurrentJobs(String uuid, String job) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		List<String> b = cl.get().getStringList("Player."+uuid+".CurrentJob");
		b.add(job);
		cl.get().set("Player."+uuid+".CurrentJob", b);
		cl.save();
	}
	
	public void remCurrentJobs(String uuid, String job) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		List<String> b = cl.get().getStringList("Player."+uuid+".CurrentJob");
		b.remove(job);
		cl.get().set("Player."+uuid+".CurrentJob", b);
		cl.save();
	}
	
	public void setCurrentJobsToNull(String uuid) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();

		cl.get().set("Player."+uuid+".CurrentJob", null);
		cl.save();
	}
	
	public List<String> getCurrentJobs(String uuid) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		return cl.get().getStringList("Player."+uuid+".CurrentJob"); 
	}
	
	public int getMaxJobs(String uuid) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		return cl.get().getInt("Player."+uuid+".MaxJobs"); 
	}
	
	public List<String> getOwn(String uuid) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		return cl.get().getStringList("Player."+uuid+".OwnsJob"); 
	}
	
	public boolean ownJob(String uuid, String id) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		return cl.get().getStringList("Player."+uuid+".OwnsJob").contains(id); 
	}
	
	public boolean existPlayer(String uuid) {
		PlayerJobDataFile cl = UltimateJobs.getPlayerDataFile();
		cl.load();
		return cl.get().contains("Player."+uuid+".CurrentJob");
	}

}
