package motionExample;
import java.io.IOException;
import com.leapmotion.leap.*;

public class Tester {

	public static void main(String args[]) {
		TestListener test_lit = new TestListener();
		Controller controller = new Controller();
		controller.addListener(test_lit);
		System.out.println("Press Enter to quit.");
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		controller.removeListener(test_lit);
	}

	static class TestListener extends Listener {

		long cur_time;
		long hit_time;

		@Override
		// Called once, when this Listener object is added to a Controller.
		public void onInit(Controller controller) {
			System.out.println("Init'd");
		}

		@Override
		// Called when this Listener object is added to a Controller that is
		// already connected.
		public void onConnect(Controller controller) {
			hit_time = System.currentTimeMillis();
			controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
			controller.enableGesture(Gesture.Type.TYPE_SWIPE);
			System.out.println("Connect'd");
		}

		@Override
		// Called when this Listener object is removed from the Controller
		// or the Controller instance is destroyed.
		public void onExit(Controller controller) {
			System.out.println("Exit'd");
		}

		@Override
		// Called when a new frame of hand and finger tracking data is
		// available.
		public void onFrame(Controller controller) {
			Frame frame = controller.frame();
			HandList hand_list = frame.hands();
			cur_time = System.currentTimeMillis();
			// Need to make sure that sensor does not over-read, 
			// and both hands are needed for this
			if (cur_time >= hit_time + 1000 && hand_list.count() > 1) {
				int cur_num = -3;
				Hand right_hand = hand_list.rightmost();
				GestureList gesture_list = frame.gestures();
				for (int i = 0; i < gesture_list.count(); i++) {
					Gesture current_gesture = gesture_list.get(i);
					if (current_gesture.type().equals(Gesture.Type.TYPE_CIRCLE)) {
						CircleGesture circle = new CircleGesture(current_gesture);
						// Pointable is the finger object, direction is the
						// direction of the finger
						// in vector form, and we are checking the angle between
						// it and the
						// vector that is the normal of the circle.
						if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI / 2) {
							// clockwise, API says <= Math.PI / 4 
							// for this, but that seems too sensitive.
							if(current_gesture.hands().rightmost().equals(right_hand)) {
								// it is from the right
								cur_num = 0;
							} else { 
								// else it is from left
								cur_num = 6;
							}
						} else {
							// counter-clockwise otherwise
							if(current_gesture.hands().rightmost().equals(right_hand)) {
								// it is from the right
								cur_num = 1;
							} else {
								// else it is from left
								cur_num = 7;
							}
						}
					}
					if (current_gesture.type().equals(Gesture.Type.TYPE_SWIPE)) {
						SwipeGesture swipe = new SwipeGesture(current_gesture);
						Vector swipe_vector = swipe.direction();
						float x_direction = swipe_vector.getX();
						float y_direction = swipe_vector.getY();
						// horizontal type of swipe check
						if (Math.abs(x_direction) > Math.abs(y_direction)) {
							// left is negative, right is positive
							if(current_gesture.hands().rightmost().equals(right_hand)) {
								if (x_direction < 0) {
									cur_num = 2;
								} else {
									cur_num = 3;
								}
							} else {
								if (x_direction < 0) {
									cur_num = 8;
								} else {
									cur_num = 9;
								}
							}
						} 
						// vertical type of swipe check
						// note, diagonal swiping has ambigous behavior
						if (Math.abs(x_direction) <= Math.abs(y_direction)) {
							// down is negative, up is positive
							if(current_gesture.hands().rightmost().equals(right_hand)) {
								if (y_direction < 0) {
									cur_num = 4;
								} else {
									cur_num = 5;
								}
							} else {
								if (y_direction < 0) {
									// This represents enter
									cur_num = -1;
								} else {
									// This represents cancel or backspace
									cur_num = -2;
								}
							}
						}
					}
				}
				if(cur_num > -3) {
					System.out.println(cur_num);
					hit_time = System.currentTimeMillis();
					System.out.println(controller.frame().currentFramesPerSecond());
					System.out.println(hit_time);
					
				}
			}
		}
	}
}