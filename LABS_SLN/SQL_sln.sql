⌨️ Labs

👉 Use the Sakila Database 👉 Analyze the database tables to solve the queries below.

❓ Which actors have the first name 'Scarlett'

❓ Which actors have the last name 'Johansson'

❓ How many distinct actors last names are there?

❓ Which last names are not repeated?

❓ Which last names appear more than once?

❓ Which actor has appeared in the most films?

❓ Is 'Academy Dinosaur' available for rent from Store 1?

❓ Which copies of films are at Store 1?

❓ Insert a record to represent Mary Smith renting 'Academy Dinosaur' from Mike Hillyer at Store 1 today .

❓ Find the last or most recent rental?

❓ What is that average length of all the films in the sakila DB?

❓ What is the average length of films by category?

❓ Which film categories are longer than the average lenght of all the films?

USE SAKILA;
Select * from actor where first_name = 'Scarlett';
Select * from actor where last_name = 'Johansson';
Select count(distinct last_name) from actor;
select last_name, count(last_name) as appear from actor group by last_name having appear=1;
select last_name, count(last_name) as appear from actor group by last_name having appear>1;
select a.actor_id, a.first_name, a.last_name, count(a.actor_id) as appear from film_actor fa inner join actor a on a.actor_id = fa.actor_id
group by fa.actor_id order by appear desc limit 1;
select f.title, s.store_id from film f inner join inventory i on f.film_id = i.film_id inner join store s on i.store_id = s.store_id where s.store_id=1;

select f.title, s.store_id, i.inventory_id
from inventory i inner join store s on i.store_id = s.store_id inner join film f on i.film_id = f.film_id
where f.title = 'Academy Dinosaur' and s.store_id = 1;


insert into rental (rental_date, inventory_id, customer_id, staff_id)
values (NOW(), 1, 1, 1);

SELECT c.last_name, c.first_name, max(r.rental_date) as "latest" FROM customer c INNER JOIN rental r
     ON c.customer_id = r.customer_id GROUP BY c.customer_id ORDER BY latest desc limit 1;

select avg(length) from film;

select category.name, avg(film.length) from film join film_category using (film_id) join category using (category_id)
group by category.name order by avg(length) desc;

select category.name, avg(film.length) from film join film_category using(film_id) join category using (category_id)
group by category.name having avg(film.length) > (select avg(length) from film);

select film.title, l.name, c.name from film join film_category fc on film.film_id = fc.film_id
join category c on fc.category_id = c.category_id inner join language l on film.language_id = l.language_id;

SELECT * from staff;
select * from customer;
select * from rental;
select * from inventory;
select * from film;
select * from film_category;
select * from store;
select * from category;
select * from film_text;