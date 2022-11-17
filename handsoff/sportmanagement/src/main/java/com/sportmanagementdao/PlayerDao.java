package com.sportmanagementdao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sportmanagemententity.Player;
import com.util.HibernateUtil;

public class PlayerDao {

	/**
	 * Save Instructor
	 * 
	 * @param instructor
	 */
	public void savePlayer(Player player) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(player);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Instructor
	 * 
	 * @param instructor
	 */
	public void updatePlayer(Player player) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(player);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Instructor
	 * 
	 * @param id
	 */
	public void deletePlayer(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a instructor object
			Player player = session.get(Player.class, id);
			if (player != null) {
				session.delete(player);
				System.out.println("instructor is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Instructor By ID
	 * 
	 * @param id
	 * @return
	 */
	public Player getInstructor(int id) {

		Transaction transaction = null;
		Player player = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object
			player = session.get(Player.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return player;
	}

	/**
	 * Get all Instructors
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayer() {

		Transaction transaction = null;
		List<Player> listOfPlayer = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an instructor object

			listOfPlayer = session.createQuery("from Instructor").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfPlayer;
	}
}