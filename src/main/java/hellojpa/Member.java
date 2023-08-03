package hellojpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity {
	@Id @GeneratedValue
	private Long id;
	@Column(name = "USERNAME")
	private String username;
	//@Column(name = "TEAM_ID")
	//private Long teamId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	/*
	@OneToOne
	@JoinColumn(name = "LOCKER_ID")
	private Locker locker;

	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberProduct = new ArrayList<>();

	 */

	@Embedded
	private Period workPeriod;
	@Embedded
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
			@AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
	})
	private Address workAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	*/

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}

	public Period getWorkPeriod() {
		return workPeriod;
	}

	public void setWorkPeriod(Period workPeriod) {
		this.workPeriod = workPeriod;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
}
