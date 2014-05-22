package com.example.task_picture_list;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task_anonymous {
	public void a() {

	}

	public ActionListener saveAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Task_anonymous.this.a();
			}
		};
	}
}
