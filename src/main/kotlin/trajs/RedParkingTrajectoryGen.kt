package trajs

import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints

object RedParkingTrajectoryGen {
    // Remember to set these constraints to the same values as your DriveConstants.java file in the quickstart
    private val driveConstraints = DriveConstraints(60.0, 60.0, 0.0, 270.0.toRadians3, 270.0.toRadians3, 0.0)

    // Remember to set your track width to an estimate of your actual bot to get accurate trajectory profile duration!
    private const val trackWidth = 16.0

    private val combinedConstraints = MecanumConstraints(driveConstraints, trackWidth)

    private val startPose = Pose2d(0.0, -62.0, 0.0.toRadians1)

    fun createTrajectory(): ArrayList<Trajectory> {
        val list = ArrayList<Trajectory>()

        val builder1 = TrajectoryBuilder(startPose, startPose.heading, combinedConstraints)

        builder1.forward(35.0);

        // Small Example Routine
//        builder1
//            .splineTo(Vector2d(10.0, 10.0), 0.0)
//            .splineTo(Vector2d(15.0, 15.0), 90.0);

        list.add(builder1.build())

        return list
    }

    fun drawOffbounds() {
        GraphicsUtil.fillRect(Vector2d(0.0, -63.0), 18.0, 18.0) // robot against the wall
    }
}

val Double.toRadians6 get() = (Math.toRadians(this))
