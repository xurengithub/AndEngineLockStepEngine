package com.niffy.AndEngineLockStepEngine.flags;

import android.os.Bundle;
import android.os.Message;

import com.niffy.AndEngineLockStepEngine.LockstepNetwork;
import com.niffy.AndEngineLockStepEngine.threads.CommunicationThread;
import com.niffy.AndEngineLockStepEngine.threads.tcp.BaseSocketThread;
import com.niffy.AndEngineLockStepEngine.threads.tcp.TCPCommunicationThread;

/**
 * Flags to indicate packet type
 * 
 * @author Paul Robinson
 * @since 28 Mar 2013 21:05:51
 */
public final class ITCFlags {
	// ===========================================================
	// Constants
	// ===========================================================
	/**
	 * This will send from {@link CommunicationThread} to the main activity.
	 * This will need to be passed onto {@link LockstepNetwork}<br>
	 * {@link Message#getData()} {@link Bundle} will contain a {@link String}
	 * with the key <code>ip</code> This will contain the IP address of the
	 * client. <br>
	 * <b>The main activity should not act upon this flag, other then pass it on
	 * to {@link LockstepNetwork}</b>
	 */
	public final static int CLIENT_CONNECTED = 0;
	/**
	 * This will send from {@link CommunicationThread} to the main activity.
	 * This will need to be passed onto {@link LockstepNetwork}<br>
	 * {@link Message#getData()} {@link Bundle} will contain a {@link String}
	 * with the key <code>ip</code> This will contain the IP address of the
	 * client. <br>
	 * <b>The main activity should not act upon this flag, other then pass it on
	 * to {@link LockstepNetwork}</b>
	 */
	public final static int CLIENT_DISCONNECTED = 1;
	/**
	 * This will send from {@link CommunicationThread} to the main activity.
	 * This will need to be passed onto {@link LockstepNetwork} <br>
	 * <b>The main activity should not act upon this flag, other then pass it on
	 * to {@link LockstepNetwork}</b>
	 */
	public final static int CLIENT_ERROR = 2;
	/**
	 * This will be passed from {@link BaseSocketThread} to
	 * {@link TCPCommunicationThread} thread
	 */
	public final static int TCP_CLIENT_INCOMMING = 10;
	/**
	 * This will be passed from {@link TCPCommunicationThread} to
	 * {@link BaseSocketThread}
	 */
	public final static int TCP_CLIENT_OUTGOING = 11;
	/**
	 * This will be passed from {@link TCPCommunicationThread} to
	 * {@link BaseSocketThread} to shut down the socket
	 */
	public final static int NETWORK_TCP_SHUTDOWN_SOCKET = 12;
	/**
	 * This will be passed from the main activity, either for itself or on
	 * behalf of {@link LockstepNetwork}, Subclasses of
	 * {@link CommunicationThread} will have to handle sending the message in
	 * their own way.
	 */
	public final static int SEND_MESSAGE = 20;
	/**
	 * This will be passed from subclass of {@link CommunicationThread} to the
	 * main activity for it to process itself.
	 */
	public final static int RECIEVE_MESSAGE_CLIENT = 21;
	/**
	 * This will be passed from subclass of {@link CommunicationThread} to the
	 * main activity for it to pass on to {@link LockstepNetwork}
	 */
	public final static int RECIEVE_MESSAGE_LOCKSTEP = 22;
	/**
	 * This will be passed from the main activity to inform of a lockstep
	 * increment.
	 */
	public final static int LOCKSTEP_INCREMENT = 900;
	/**
	 * This will passed from subclass of {@link CommunicationThread} to main
	 * activity to pass onto {@link LockstepNetwork}. This will only happen if
	 * the network gets {@link ErrorCodes#CLIENT_WINDOW_NOT_EMPTY} <br>
	 * {@link Message#getData()} {@link Bundle} will contain a {@link String}
	 * with the key <code>ip</code> This will contain the IP address of the
	 * client. <br>
	 * <b>The main activity should not act upon this flag, other then pass it on
	 * to {@link LockstepNetwork}</b>
	 */
	public final static int CLIENT_WINDOW_NOT_EMPTY = 901;
	/**
	 * This will be passed from the subclasses of {@link CommunicationThread} to
	 * the main activity for it self and the {@link LockstepNetwork}.
	 * The main activity should process this flag after it has handed it to {@link LockstepNetwork}
	 */
	public final static int NETWORK_ERROR = 1000000;
	/**
	 * This will be passed from {@link BaseSocketThread} to
	 * {@link TCPCommunicationThread} when the connection has closed or an
	 * error. Most likely client disconnect. <br>
	 * {@link Message#getData()} {@link Bundle} will contain a {@link String}
	 * with the key <code>ip</code> This will contain the IP address of the
	 * client. <br>
	 * This should trigger {@link TCPCommunicationThread} to send
	 * {@link #CLIENT_DISCONNECTED} to the main activity
	 */
	public final static int NETWORK_TCP_EXCEPTION = 1000001;
	/**
	 * This will be passed from {@link CommunicationThread} to main activity if
	 * it could not send a message to a client. {@link Message#getData()}
	 * {@link Bundle} will contain a {@link String} with the key <code>ip</code>
	 * This will contain the IP address of the client. <br>
	 * It will also contain a byte array of key <code>data</code> of the
	 * message, this data may be incomplete! <br>
	 * An {@link Integer} with the key <code>error</code> will contain the error
	 * code.
	 */
	public final static int NETWORK_SEND_MESSAGE_FAILURE = 1000002;
	/**
	 * This will be passed from {@link CommunicationThread} to main activity if
	 * it could not receive a message from a client. {@link Message#getData()}
	 * {@link Bundle} will contain a {@link String} with the key <code>ip</code>
	 * This will contain the IP address of the client. <br>
	 * It will also contain a byte array of key <code>data</code> of the
	 * message, this data may be incomplete! <br>
	 * An {@link Integer} with the key <code>error</code> will contain the error
	 * code.
	 */
	public final static int NETWORK_RECIEVE_FAILURE = 1000003;
}