<?php
include 'setlang.php';
?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
		<title><?= $langini[$lang][title]; ?></title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">

		<link rel="stylesheet" type="text/css" href="../css/animate.css"/>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="../js/viewportchecker.js"></script>
		<script src="../js/anchor.js"></script>
		<script src="../js/index.js"></script>

		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link rel="shortcut icon" href="../image/favicon.ico">
	</head>

	<body>
		<div class="wrapper">
			<header class="header">
			    <?= $langhtml; ?>
				<div id = "wrappersocial" class="wrappersocial default">
					<!--
					<div class="contactbox">
					<span class="name">skype:</span>
					yulia.vidomenko
					<span class="name">e-mail:</span>
					yuliya-okhrimenko@rambler.ru
					<span class="name">тел.:</span>
					+38(066)462-97-35
					-->

					<div class="fb social">
						<img src="../image/fb.png">
					</div>
					<div class="tw social">
						<img src="../image/tw.png">
					</div>
					<div class="vk social">
						<img src="../image/vk.png">
					</div>
					<div class="in social">
						<img src="../image/in.png">
					</div>
					<div class="ok social">
						<img src="../image/ok.png">
					</div>
					<div class="feedback">
						<?= $langini[$lang][feedback]; ?>
					</div>
				</div>

				<div class="logo">
					<a href="index.php"> <img src="../image/logo.png"> </a>
				</div>
				<div class="slogan">
					<?= $langini[$lang][slogan]; ?>
				</div>
				<div id="feedbackform" class="default">
					<h3>Заказ звонка</h3>
					<form id="order-phone-form" action="#">
						<div class="message" style="display: none"></div>
						<div class="form">
							<p>
								<label for="order-phone-number">Ваш номер телефона</label>
								<input id="order-phone-number" type="text" name="order-phone-number" required="required" kl_virtual_keyboard_secure_input="on">
							</p>
							<p>
								<label for="order-phone-name">Ваше имя</label>
								<input id="order-phone-name" type="text" name="order-phone-name" kl_virtual_keyboard_secure_input="on">
							</p>
						</div>
						<div class="order-button">
							<input type="submit" value="Заказ">
						</div>
					</form>
				</div>
				<div id="menu" class="default">
					<ul>
						<li>
							<a href="#sectionnews"><?= $langini[$lang][menunews]; ?></a>
						</li>
						<li>
							<a href="#sectioncontacts"><?= $langini[$lang][menucontacts]; ?></a>
						</li>
						<li>
							<a href="#sectionprograms"><?= $langini[$lang][menuprograms]; ?></a>
						</li>
						<li>
							<a href="#sectionlanguage"><?= $langini[$lang][menulanguage]; ?></a>
						</li>
						<li>
							<a href="#sectionabout"><?= $langini[$lang][menuabout]; ?></a>
						</li>
					</ul>
				</div>

			</header><!-- .header-->

			<div class="middle">

				<div class="container">
					<div class="content">
						<!--<h1 class="title">ЛАСКАВО ПРОСИМО ДО CAT SERVICES! </h1>-->
						<div class="page-content">

							<section id="sectionabout"></section>
							<div class="boxitem">
								<ul>
									<li>
										<div class="moveup">
											<div class="contentitem">
												<p>
													<?= $langini[$lang][aboutustxt]; ?>
												</p>
											</div>
										</div>
									</li>
								</ul>

							</div>
							<div class="moveleft">
								<div class="titleOptions">
									<h2><?= $langini[$lang][ourmainprinciples]; ?><span></span></h2>
								</div>
							</div>

							<div class="boxitem">
								<ul>
									<li>
										<div class="moveleft">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][accuracy]; ?></a>
											</div>
										</div>
										<div class="moveup">
											<div class="contentitem">
												<p>
													<?= $langini[$lang][accuracytxt]; ?>
												</p>
											</div>
										</div>
									</li>
									<li>
										<div class="moveleft">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][timeliness]; ?></a>
											</div>
										</div>
										<div class="moveup">
											<div class="contentitem">
												<p>
													<?= $langini[$lang][timelinesstxt]; ?>
												</p>
											</div>
										</div>
									</li>
									<li>
										<div class="moveleft">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][isostandards]; ?></a>
											</div>
										</div>
										<div class="moveup">
											<div class="contentitem">
												<p>
													<?= $langini[$lang][isostandardstxt]; ?>
												</p>
											</div>
										</div>

									</li>
									<li>
										<div class="moveleft">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][posttranslationservices]; ?></a>
											</div>
										</div>
										<div class="moveup">
											<div class="contentitem">
												<p>
													<?= $langini[$lang][posttranslationservicestxt]; ?>
												</p>
											</div>
										</div>
									</li>
									<li>
										<div class="moveleft">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][confidentiality]; ?></a>
											</div>
										</div>
										<div class="moveup">
											<div class="contentitem">
												<p>
													<?= $langini[$lang][confidentialitytxt]; ?>
												</p>
											</div>
										</div>
									</li>
									
									<li>
										<div class="moveleft">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][processstages]; ?></a>
											</div>
										</div>
									</li>
									<li>
										<div class="contentitemline">
											<div class="containerline">
												<div class="boxtrans animated boxHidded">
													<div class="containerlineitem_translate">

													</div>
													<div class="boxtext">
														<?= $langini[$lang][stagetranslation]; ?>
													</div>
												</div>
												<div class="boxtrans arrowright animated boxHidded delay-03s">

												</div>
												<div class="boxtrans animated boxHidded delay-06s">
													<div class="containerlineitem_edit">

													</div>
													<div class="boxtext">
														<?= $langini[$lang][stagerevision]; ?>
													</div>
												</div>
												<div class="boxtrans arrowright animated boxHidded delay-09s">

												</div>
												<div class="boxtrans animated boxHidded delay-12s">
													<div class="containerlineitem_review">

													</div>
													<div class="boxtext">
														<?= $langini[$lang][stagereview]; ?>
													</div>
												</div>
												<div class="boxtrans arrowright animated boxHidded delay-15s">

												</div>
												<div class="boxtrans animated boxHidded delay-18s">
													<div class="containerlineitem_qa">

													</div>
													<div class="boxtext">
														<?= $langini[$lang][stagequalityassurance]; ?>
													</div>
												</div>
											</div>
									</li>
									<li>
										<div class="moveup">
											<div class="contentitem">
												<?= $langini[$lang][processstagestxt]; ?>
											</div>
										</div>
									</li>
							</div>
							<section id="sectionlanguage"></section>
							<div class="boxitem">
								<ul>
									<div class="moveup">
										<div class="titleOptionsforlang">
											<h2><?= $langini[$lang][languages]; ?><span></span></h2>
										</div>
									</div>
									<li>
										<div class="moveup">
											<div class="titleitem">
												<a class="title" href="#">•	<?= $langini[$lang][languagecombinations]; ?></a>
											</div>
										</div>
										<div class="containerlinelang">

											<div class="langl animated boxHidded">
												<div class="langline">
													<p>
														<?= $langini[$lang][translation_englishintorussian]; ?>
													</p>
													<p>
														<?= $langini[$lang][translation_russianintoenglish]; ?>
													</p>
												</div>
											</div>

											<div class="langr animated boxHidded delay-06s">
												<div class="langline">
													<p>
														<?= $langini[$lang][translation_englishintoukrainian]; ?>
													</p>
													<p>
														<?= $langini[$lang][translation_ukrainianintoenglish]; ?>
													</p>
												</div>
											</div>

											<div class="langl animated boxHidded delay-12s">
												<div class="langline">
													<p>
														<?= $langini[$lang][translation_germanintorussian]; ?>
													</p>
													<p>
														<?= $langini[$lang][translation_russianintogerman]; ?>
													</p>
												</div>
											</div>

											<div class="langr animated boxHidded delay-18s">
												<div class="langline">
													<p>
														<?= $langini[$lang][translation_germanintoukrainian]; ?>
													</p>
													<p>
														<?= $langini[$lang][translation_ukrainianintogerman]; ?>
													</p>
												</div>
											</div>
											<li>
												<div class="moveup">
													<div class="contentitemother">
														<?= $langini[$lang][otherlanguage]; ?>
													</div>
												</div>
											</li>
											<li>
												<div class="moveup">
													<div class="contentitemlang">
														<p>
															<?= $langini[$lang][professionaltranslators]; ?>
														</p>
													</div>
												</div>
											</li>
										</div>
									</li>

								</ul>
								
								<section id="sectionprograms"></section>
								<div class="boxitem">
									<ul>
										<div class="moveup">
											<div class="titleOptionsfortools">
												<h2><?= $langini[$lang][cattools]; ?><span></span></h2>
											</div>
										</div>
										<li>
											<div class="moveup">
												<div class="titleitem">
													<a class="title" href="#">• <?= $langini[$lang][cattoolstxt]; ?></a>
												</div>
											</div>
											<div class="containerlinetools">
												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][SDL_Trados_Studio_2009_2011_2014]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][SDL_Trados_2007]; ?>
														</p>
													</div>
												</div>

												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][MemoQ]; ?>
														</p>
													</div>
												</div>

												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][MemSource_Editor]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][SDL_Multiterm_Extract_2011_2014]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][ApSIC_Xbench]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="toolsline">
														<p>
															<?= $langini[$lang][Verifika]; ?>
														</p>
													</div>
												</div>
												
												<li>
													<div class="moveup">
														<div class="contentitemtools">
															<p>
																<?= $langini[$lang][ChoosingCAT]; ?>
															</p>
														</div>
													</div>
												</li>
											</div>
										</li>

									</ul>

								</div>
								<section id="sectioncontacts"></section>
								<div class="boxitem">
									<ul>
										<div class="moveup">
											<div class="titleOptionsforcont">
												<h2><?= $langini[$lang][contacts]; ?><span></span></h2>
											</div>
										</div>
										<li>
											<div class="moveup">
												<div class="titleitem">
													<a class="title" href="#"><?= $langini[$lang][freetocontact]; ?></a>
												</div>
											</div>
											<div class="containerlinecont">
												<div class="moveup animated boxHidded">
													<div class="contline">
														<p>
															<?= $langini[$lang][sales_department_phone]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="contline">
														<p>
															<?= $langini[$lang][sales_department_email]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="contline">
														<p>
															<?= $langini[$lang][sales_department_skype]; ?>
														</p>
													</div>
												</div>
												<br />
												<div class="moveup animated boxHidded">
													<div class="contline">
														<p>
															<?= $langini[$lang][production_department_phone]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="contline">
														<p>
															<?= $langini[$lang][production_department_email]; ?>
														</p>
													</div>
												</div>
												<div class="moveup animated boxHidded">
													<div class="contline">
														<p>
															<?= $langini[$lang][production_department_skype]; ?>
														</p>
													</div>
												</div>
											</div>

										<li>
											<div class="moveup">
												<div class="contentitemcont">
													<p>
														<?= $langini[$lang][join_our_team]; ?>
													</p>
												</div>
											</div>
										</li>

									</ul>

								</div>
							</div>

						</div><!-- .content -->
					</div><!-- .container-->

					<aside class="left-sidebar">

					</aside><!-- .left-sidebar -->

					<aside class="right-sidebar">

					</aside><!-- .right-sidebar -->

				</div><!-- .middle-->
			</div><!-- .wrapper -->
			<footer class="footer">
				*
			</footer><!-- .footer -->
			<div id="overlay" class="overlay" style="display: none;"></div>
	</body>
</html>
