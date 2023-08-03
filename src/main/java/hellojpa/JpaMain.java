package hellojpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			/*
			Member member = new Member();

			member.setId(2L);
			member.setName("HelloB");
			em.persist(member);
			 */
			/*
			Member findMember = em.find(Member.class, 1L);
			findMember.setName("HelloJPA");

			 */
			/*
			List<Member> result = em.createQuery("select m from Member as m", Member.class)
					.setFirstResult(1)
					.setMaxResults(10)
							.getResultList();

			for(Member member : result ) {
				System.out.println("find List : "+member.getName());
			}

			 */
			/*
			Member member = new Member();
			member.setId(101L);
			member.setName("HelloJPA");
			em.persist(member);
			 */
			/*
			Member member1 = new Member(150L,"A");
			Member member2 = new Member(160L,"B");

			em.persist(member1);
			em.persist(member2);
			System.out.println("===================");

			 */
			/*
			Member member = em.find(Member.class, 150L);
			member.setName("ZZZZZ");

			 */
			/*
			Member member = new Member(200L,"member200");
			em.persist(member);
			em.flush();

			 */
			/*
			Member member = new Member();

			member.setUsername("C");

			 */
			/*
			Member1 member1 = new Member1();
			member1.setUsername("A");
			Member1 member2 = new Member1();
			member2.setUsername("B");
			Member1 member3 = new Member1();
			member3.setUsername("D");

			em.persist(memberPart11);
			em.persist(memberPart12);
			em.persist(memberPart13);

			 */

			//팀 저장
			/*
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			//회원 저장
			Member member = new Member();
			member.setUsername("member1");
			member.setTeam(team);
			em.persist(member);

			em.flush();
			em.clear();

			 */


			/*
			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			System.out.println("findTeam=="+findTeam.getId());


			Team newTeam = em.find(Team.class, 100L);
			findMember.setTeam(newTeam);

			 */
			/*
			Member findMember = em.find(Member.class, member.getId());
			List<Member> members = findMember.getTeam().getMembers();

			for(Member m : members) {
				System.out.println("m= "+m.getUsername());
			}

			 */
/*
			Movie movie = new Movie();
			movie.setDirector("aaaa");
			movie.setActor("bbbb");
			movie.setName("바람과 함께 사라지다");
			movie.setPrice(10000);

			em.persist(movie);

			em.flush();
			em.clear();

			Movie findMovie = em.find(Movie.class, movie.getId());
			System.out.println("findMovie=="+ findMovie);

 */
			/*
			Member member = new Member();
			member.setUsername("user1");
			member.setCreateBy("kim");
			member.setCreateDate(LocalDateTime.now());
			em.persist(member);

			em.flush();
			em.clear();

			//
			//Member findMember = em.find(Member.class, member.getId());
			Member findMember = em.getReference(Member.class, member.getId());
			System.out.println("findMember.getId"+ findMember.getId());
			System.out.println("findMember.getUsername="+ findMember.getUsername());

			 */
			/*
			Member member1 = new Member();
			member1.setUsername("user1");
			member1.setCreateBy("kim");
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("user1");
			member2.setCreateBy("kim");
			em.persist(member2);

			em.flush();
			em.clear();

			Member m1 = em.find(Member.class, member1.getId());
			Member m2 = em.getReference(Member.class, member2.getId());

			//logic(m1, m2);
			Member reference = em.getReference(Member.class, member1.getId());
			System.out.println("reference = "+reference.getClass());

			 */
			/*
			Member member1 = new Member();
			member1.setUsername("user1");
			em.persist(member1);

			em.flush();
			em.clear();
			Member refMember = em.getReference(Member.class, member1.getId());
			// 초기화
			// refMember.getUsername();
			// or 강제 초기화
			//Hibernate.initialize(refMember);
			System.out.println("isLoaded = "+ emf.getPersistenceUnitUtil().isLoaded(refMember));

			 */

			/*
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);

			Team team1 = new Team();
			team.setName("teamB");

			em.persist(team1);

			Member member1 = new Member();
			member1.setUsername("user1");
			member1.setTeam(team);
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("user2");
			member2.setTeam(team1);

			em.persist(member2);

			em.flush();
			em.clear();

			List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
					.getResultList();
			//SQL: select * from Member
			//SQL: select * from Team Where TEAM_ID = xxx

			 */
			/*
			Member m = em.find(Member.class, member1.getId());

			System.out.println("m = "+m.getTeam().getClass());

			System.out.println("===========");
			System.out.println("team Name="+m.getTeam().getName()); //초기화
			System.out.println("===========");

			 */
			/*
			Child child1 = new Child();
			Child child2 = new Child();

			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);

			em.persist(parent);
			//em.persist(child1);
			//em.persist(child2);

			em.flush();
			em.clear();

			Parent findParent = em.find(Parent.class, parent.getId());
			findParent.getChildList().remove(0);

			//em.remove(findParent);

			 */
			Member member = new Member();
			member.setUsername("hello");
			member.setHomeAddress(new Address("city","street","zipcode"));

			em.persist(member);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}


		em.close();

		emf.close();
	}

	private static void logic(Member m1, Member m2) {
		//System.out.println("m1 == m2 : "+(m1.getClass() == m2.getClass()));
		System.out.println("m1 == m2 : "+(m1 instanceof Member));
		System.out.println("m1 == m2 : "+(m2 instanceof Member));
	}
}
