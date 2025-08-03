enum class Direction {
    INCLINE,
    DECLINE,
}

// time: O(n)
// space: O(1)

fun countHillValleys(nums: IntArray): Int {
    var hills = 0
    var valleys = 0
    var direction: Direction? = null

    for ((i, current) in nums.withIndex()) {
        if (i == 0) continue
        val previous = nums[i - 1]
        if (current > previous) {
            if (direction == Direction.DECLINE) valleys++
            direction = Direction.INCLINE
        } else if (current < previous) {
            if (direction == Direction.INCLINE) hills++
            direction = Direction.DECLINE
        }
    }

    return hills + valleys
}

fun main() {
//    val input = intArrayOf(2, 4, 1, 1, 6, 5)
    val input = intArrayOf(5, 5, 5, 1, 5, 5, 5)
    val output = countHillValleys(input)

    println(output)
}

/*
 * hill: 0111110
 * valley: 100001
 *
 * have a counter for hills
 * have a counter for valleys
 *
 * have a var for mode incline/decline
 * loop through each int
 * - if same, go to next
 * - if cur > prev
 *   - if mode = decline, valley++
 *   - mode = incline
 * - if cur < prev
 *   - if mode = incline, hill++
 *   - mode = decline
 *  */
