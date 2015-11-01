package com.github.pixelase.bot.api;

import com.pengrad.telegrambot.model.Message;

public abstract class Task implements Runnable {
	protected Message message;
	protected boolean isOk;
	protected static long taskTimeout;

	public Task() {
		this(null, true);
	}

	private Task(Message message, boolean isOk) {
		super();
		this.message = message;
		this.isOk = isOk;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public static long getTaskTimeout() {
		return taskTimeout;
	}

	public static void setTaskTimeout(long taskTimeout) {
		Task.taskTimeout = taskTimeout;
	}

	protected void sleep(long millis) {
		/*
		 * Hot fix
		 */
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
