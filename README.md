=======================================
Paint Shop
=======================================

### Situations:
- Shop only allowed a customer to choose 1 matte.(No customer will like more than one color in matte.)
- At least one colour, the customer will like.(For each customer, there is at least one color they like)
- If it is possible to use Gloss(You make as few mattes as possible).

### Target:
We expect to get all Gloss colour, as few mattes as possible. 
In some cases it is necessary to use a matte/gloss, we need to consider.
- a customer choose a matte/gloss
- a customer choose a matte/gloss and other gloss/matte. But the gloss/matte colours are occupied by other customer's matte.
- do not consider gloss too much. 


### No solution exist:
 2 or more customers have totally different choosing in same colour.
 
### How to calculate it?
- sort all customer choosing from less to more.
- choose matte or gloss for each colour according to "Target", create a temporary final solution.
- we will do the calculation : there are customers to choose only 1 colour.
- we confirm the colour by choosing 1 colour. if the choosing colours number is more than 1, we will create a new temporary list for next loop, reducing some token colours.
- If customers choosing colours amount more more than 2, and STOP calculation then fill G for rest colours.


### Main idea
confirm 1 colour and fix 1 colour attribute. re-calculate the treated list.

