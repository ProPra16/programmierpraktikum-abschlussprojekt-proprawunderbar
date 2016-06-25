package tddt.code;

import javafx.scene.text.Text;

/* Benutzung:
	Timer erstellen:
	  Text text = new Text()
	  Timer timer = new Timer(text)
	
	Timer starten oder stoppen:
	  timer.start() bzw. timer.stop()
	
	Timer auf 0 setzen:
	  timer.reset()
	
	Timer auf 1:37 setzen:
	  timer.setTo(97)
	
	Am besten bei Programmende kill benuzten:
	  timer.kill();
	
	RTFM.
*/
public class Timer {
	volatile int seconds;
	volatile boolean clocking;
	volatile boolean running;

	public Timer(Text text) {
		seconds = 0;
		clocking = false;
		running = true;
		text.setText(MinutesSeconds());

		Thread clock = new Thread(() -> {
			while (running) {
				while (clocking) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// nix!
					}
					seconds++;
					text.setText(MinutesSeconds());
				}
				try {
					Thread.sleep(20);
					// Um zu verhindern, dass die
					// die CPU sonst auf 100% läuft.
				} catch (Exception e) {
					// nix!
				}
			}
		});

		clock.start();
	}

	public void start() {
		clocking = true;
	}

	public void stop() {
		clocking = false;
	}

	public void kill() {
		clocking = false;
		running = false;
	}

	public int getTotalSeconds() {
		return seconds;
	}

	public void reset() {
		seconds = 0;
	}

	public void setTo(int newSeconds) {
		seconds = newSeconds;
	}


	private int getSeconds() {
		int temp_seconds = seconds;
		while (temp_seconds >= 60) {
			temp_seconds -= 60;
		}
		return temp_seconds;
	}

	private int getMinutes() {
		int temp_seconds = seconds;
		int temp_minutes = 0;
		while (temp_seconds >= 60) {
			temp_seconds -= 60;
			temp_minutes++;
		}
		return temp_minutes;
	}

	private String MinutesSeconds() {
		if (getSeconds() > 9)
			return getMinutes() + ":" + getSeconds();
		return getMinutes() + ":0" + getSeconds();
	}
}
