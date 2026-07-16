# Write your MySQL query statement below
SELECT s.user_id, ROUND(IFNULL(SUM(c.action = 'confirmed')/COUNT(c.action), 0), 2) AS confirmation_rate #2 is for rounding off to nearest 2 decimals
FROM Signups s
LEFT JOIN Confirmations c
ON c.user_id = s.user_id
GROUP BY s.user_id